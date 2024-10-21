package randommemes.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import randommemes.item.ModItems;

public class PropellerHat extends ArmorItem {
	public PropellerHat(RegistryEntry<ArmorMaterial> material, Type slot, Settings settings) {
		super(material, slot, settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (entity instanceof PlayerEntity player) {
			if (player.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.PROPELLER_HAT) {
				if (player.isCreative() || player.isSpectator()) return;

				player.getAbilities().allowFlying = true;
				player.getAbilities().flying = true;
			}
		}

		super.inventoryTick(stack, world, entity, slot, selected);
	}
}
