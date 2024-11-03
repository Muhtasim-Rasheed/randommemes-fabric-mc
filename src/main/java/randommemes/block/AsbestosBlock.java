package randommemes.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.slf4j.Logger;
import randommemes.RandomMemes;

public class AsbestosBlock extends Block {
	private static final int TICKRATE = 2;
	private static final int RADIUS = 10;

	public AsbestosBlock(AbstractBlock.Settings settings) {
		super(settings);
	}

	@Override
	protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		super.onBlockAdded(state, world, pos, oldState, notify);

		if (!world.isClient()) {
			world.scheduleBlockTick(pos, this, TICKRATE);
		}
	}

	@Override
	protected boolean hasRandomTicks(BlockState state) {
		return true;
	}

	@Override
	protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		super.scheduledTick(state, world, pos, random);

		Logger logger = RandomMemes.LOGGER;

		int radius = RADIUS;

//		for (int x = -radius; x < radius; x++) {
//			for (int y = -radius; y < radius; y++) {
//				for (int z = -radius; z < radius; z++) {
//					// If it is raining
//					boolean raining = world.isRaining();
//
//					// Poison any entity in the radius
//					world.getEntitiesByClass(LivingEntity.class, new Box(x, y, z, x + 1, y + 1, z + 1), entity -> true).forEach(entity -> {
//						entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 5, 1));
//					});
//				}
//			}
//		}

		Box effectBox = new Box(pos).expand(radius, radius, radius);

		// Gather all living entities within the bounding box
		world.getEntitiesByClass(LivingEntity.class, effectBox, entity -> true)
						.forEach(entity -> {
							// Apply poison effect to each entity
							// Skip if the entity is already poisoned
							if (entity.hasStatusEffect(StatusEffects.POISON)) {
								return;
							}
							// Skip if it's not raining
							if (!world.isRaining()) {
								return;
							}
							entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 2, 1));
							logger.info("Poisoned entity at " + entity.getBlockPos());
						});

		// Schedule the next tick
		world.scheduleBlockTick(pos, this, TICKRATE);
	}
}
