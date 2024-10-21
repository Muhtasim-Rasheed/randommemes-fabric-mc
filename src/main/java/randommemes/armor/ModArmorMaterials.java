package randommemes.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import randommemes.RandomMemes;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
	public static final int PROPELLER_HAT_DURABILITY = 15;
	public static final RegistryEntry<ArmorMaterial> PROPELLER_HAT = register("propeller_hat", Map.of(
					ArmorItem.Type.HELMET, 4
			), 15, 0.0F, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> Ingredient.ofItems(Items.LEATHER), 0.0F, false);

	private static RegistryEntry<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, float toughness, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float knockbackResistance, boolean dyeable) {
		List<ArmorMaterial.Layer> layers = List.of(
						new ArmorMaterial.Layer(Identifier.of(RandomMemes.MOD_ID, id), "", dyeable)
		);

		ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
		material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(RandomMemes.MOD_ID, id), material);

		return RegistryEntry.of(material);
	}

	public static void init() {
		// Called in RandomMemes.onInitialize(), no need to do anything here
	}
}
