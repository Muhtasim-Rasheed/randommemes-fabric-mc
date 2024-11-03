package randommemes.item.fireywand;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class FireyWand extends ToolItem {
	public FireyWand(ToolMaterial material, Settings settings) {
		super(material, settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		// Select the block the player is looking at 3 blocks away by raycasting
		BlockHitResult hit = (BlockHitResult) user.raycast(5, 0, false);

		if (hit.getType() == BlockHitResult.Type.BLOCK)
			world.setBlockState(hit.getBlockPos(), Blocks.FIRE.getDefaultState());

		return super.use(world, user, hand);
	}
}
