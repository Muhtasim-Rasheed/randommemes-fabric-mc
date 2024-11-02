package randommemes.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Slipper extends Item {
	public Slipper() {
		super(new Item.Settings());
	}

	// Knock back 55 on hit
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.takeKnockback(55, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
		return super.postHit(stack, target, attacker);
	}
}
