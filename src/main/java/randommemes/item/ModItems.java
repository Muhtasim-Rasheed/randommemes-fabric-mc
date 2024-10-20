package randommemes.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import randommemes.RandomMemes;
import randommemes.item.fireywand.FireyWand;
import randommemes.item.hammer.Hammer;

public class ModItems {
	public static final Item HAMMER = register("hammer", new Hammer());
	public static final Item DORITOS = register("doritos", new Doritos());
	public static final Item GATORADE = register("gatorade", new Gatorade());
	public static final Item FIREY_WAND = register("firey_wand", new FireyWand());

	private static void addItemsToToolsTab(FabricItemGroupEntries entries) {
		entries.add(HAMMER);
		entries.add(FIREY_WAND);
	}

	private static void addItemsToFoodTab(FabricItemGroupEntries entries) {
		entries.add(DORITOS);
		entries.add(GATORADE);
	}

	private static Item register(String name, Item item) {
		Identifier id = Identifier.of(RandomMemes.MOD_ID, name);

		return Registry.register(Registries.ITEM, id, item);
	}

	public static void init() {
		// Register items here
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTab);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTab);
	}
}
