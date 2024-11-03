package randommemes.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import randommemes.RandomMemes;

public class ModBlocks {
	public final static Block ASBESTOS_BLOCK = register("asbestos_block", new AsbestosBlock(Block.Settings.create().sounds(BlockSoundGroup.METAL)), true);

	public static void init() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addBlocksToFunctionalTab);
	}

	private static void addBlocksToFunctionalTab(FabricItemGroupEntries entries) {
		entries.add(ASBESTOS_BLOCK.asItem());
	}

	private static Block register(String name, Block block, boolean shouldRegisterItem) {
		Identifier id = Identifier.of(RandomMemes.MOD_ID, name);

		if (shouldRegisterItem)
			// Register block item
			Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));

		// Register block
		return Registry.register(Registries.BLOCK, id, block);
	}
}
