package randommemes.datagen;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import randommemes.item.ModItems;

public class ModLootTables {
	public static void init() {
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			// If the loot table is for the simple dungeon chest, and it is not overridden by a user:
			if (LootTables.SIMPLE_DUNGEON_CHEST.equals(key) && source.isBuiltin()) {
				// Create a new loot pool that will hold the diamonds.
				LootPool.Builder pool = LootPool.builder()
								// Add asbestos ingots...
								.with(ItemEntry.builder(ModItems.ASBESTOS_INGOT).weight(1))
								// ...only if the block would survive a potential explosion.
								.conditionally(SurvivesExplosionLootCondition.builder());

				// Add the loot pool to the loot table
				tableBuilder.pool(pool);
			// If the loot table is for the abandoned mineshaft chest, and it is not overridden by a user:
			} else if (LootTables.ABANDONED_MINESHAFT_CHEST.equals(key) && source.isBuiltin()) {
				// Create a new loot pool that will hold the diamonds.
				LootPool.Builder pool = LootPool.builder()
								// Add asbestos ingots...
								.with(ItemEntry.builder(ModItems.ASBESTOS_INGOT).weight(2))
								// ...only if the block would survive a potential explosion.
								.conditionally(SurvivesExplosionLootCondition.builder());

				// Add the loot pool to the loot table
				tableBuilder.pool(pool);
			}
		});
	}
}
