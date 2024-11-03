package randommemes.item.hammer;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Hammer extends ToolItem {
	public Hammer(ToolMaterial material, Settings settings) {
		super(material, settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		Block[][][] blocks = new Block[6][6][6];

		for (int x = -3; x < 3; x++) {
			for (int y = -3; y < 3; y++) {
				for (int z = -3; z < 3; z++) {
					blocks[x + 3][y + 3][z + 3] = world.getBlockState(user.getBlockPos().add(x, y, z)).getBlock();
					// Set the block to air
					world.setBlockState(user.getBlockPos().add(x, y, z), Blocks.AIR.getDefaultState());
				}
			}
		}

		// Now drop the blocks
		for (int x = -3; x < 3; x++) {
			for (int y = -3; y < 3; y++) {
				for (int z = -3; z < 3; z++) {
					world.spawnEntity(new ItemEntity(world, user.getBlockPos().add(x, y, z).getX(), user.getBlockPos().add(x, y, z).getY(), user.getBlockPos().add(x, y, z).getZ(), new ItemStack(blocks[x + 3][y + 3][z + 3])));
				}
			}
		}

		// Decrease the durability of the hammer
		user.getStackInHand(hand).damage(20, user, EquipmentSlot.MAINHAND);

		return super.use(world, user, hand);
	}
}
