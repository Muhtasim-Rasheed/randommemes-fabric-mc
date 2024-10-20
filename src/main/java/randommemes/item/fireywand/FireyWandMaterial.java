package randommemes.item.fireywand;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class FireyWandMaterial implements ToolMaterial {
	@Override
	public int getDurability() {
		return 275;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 0;
	}

	@Override
	public float getAttackDamage() {
		return 1.1F; // Trident is 1.1F too
	}

	@Override
	public TagKey<Block> getInverseTag() {
		return BlockTags.INCORRECT_FOR_WOODEN_TOOL; // Not used for mining
	}

	@Override
	public int getEnchantability() {
		return 15;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.BLAZE_POWDER);
	}
}
