package randommemes.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.jukebox.JukeboxSongs;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import randommemes.RandomMemes;
import randommemes.armor.ModArmorMaterials;
import randommemes.armor.PropellerHat;
import randommemes.item.fireywand.FireyWand;
import randommemes.item.fireywand.FireyWandMaterial;
import randommemes.item.hammer.Hammer;
import randommemes.item.hammer.HammerMaterial;
import randommemes.sound.ModSounds;

public class ModItems {
	public static final Item HAMMER = register("hammer", new Hammer(new HammerMaterial(), new Item.Settings()));
	public static final Item DORITOS = register("doritos", new Item(new Item.Settings().food(
					new FoodComponent.Builder()
									.snack()
									.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 10, 2), 1.0F)
									.nutrition(6)
									.saturationModifier(0.6F)
									.build()
	)));
	public static final Item GATORADE = register("gatorade", new Item(new Item.Settings().food(
					new FoodComponent.Builder()
									.nutrition(6)
									.saturationModifier(0.6f)
									.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 10, 2), 1.0f)
									.usingConvertsTo(Items.GLASS_BOTTLE)
									.build()
	)));
	public static final Item FIREY_WAND = register("firey_wand", new FireyWand(new FireyWandMaterial(), new Item.Settings().maxCount(1)));
	public static final Item SLIPPER = register("slipper", new Slipper(new Item.Settings()));

	public static final Item ASBESTOS_INGOT = register("asbestos_ingot", new Item(new Item.Settings().food(
					new FoodComponent.Builder()
									.statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 30, 2), 1.0F)
									.build()
	)));

	public static final Item MUSIC_DISC_PORTAL_RADIO = register("music_disc_portal_radio", new Item((new Item.Settings()).maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModSounds.PORTAL_RADIO_KEY)));
	public static final Item MUSIC_DISC_FUNKY_TOWN = register("music_disc_funky_town", new Item((new Item.Settings()).maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModSounds.FUNKY_TOWN_KEY)));

	public static final Item PROPELLER_HAT = register("propeller_hat", new PropellerHat(ModArmorMaterials.PROPELLER_HAT, ArmorItem.Type.HELMET, new Item.Settings()));

	private static void addItemsToToolsTab(FabricItemGroupEntries entries) {
		entries.add(HAMMER);
		entries.add(FIREY_WAND);
		entries.add(MUSIC_DISC_PORTAL_RADIO);
		entries.add(MUSIC_DISC_FUNKY_TOWN);
	}

	private static void addItemsToFoodTab(FabricItemGroupEntries entries) {
		entries.add(DORITOS);
		entries.add(GATORADE);
	}

	private static void addItemsToCombatTab(FabricItemGroupEntries entries) {
		entries.add(PROPELLER_HAT);
		entries.add(SLIPPER);
	}

	private static void addItemsToIngredientsTab(FabricItemGroupEntries entries) {
		entries.add(ASBESTOS_INGOT);
	}

	private static Item register(String name, Item item) {
		Identifier id = Identifier.of(RandomMemes.MOD_ID, name);

		return Registry.register(Registries.ITEM, id, item);
	}

	public static void init() {
		// Register items here
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTab);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTab);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTab);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTab);
	}
}
