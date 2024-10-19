package randommemes.item.hammer;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class HammerMaterial implements ToolMaterial {
	@Override
	public int getDurability() {
		return 315;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 6;
	}

	@Override
	public float getAttackDamage() {
		return 10;
	}

	@Override
	public TagKey<Block> getInverseTag() {
		return BlockTags.INCORRECT_FOR_STONE_TOOL;
	}

	@Override
	public int getEnchantability() {
		return 15;
	}

	@Override
	public Ingredient getRepairIngredient() {
		// Iron ingot
		return Ingredient.ofItems(Items.IRON_INGOT);
	}
}
