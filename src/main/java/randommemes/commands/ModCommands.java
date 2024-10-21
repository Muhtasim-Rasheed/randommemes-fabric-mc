package randommemes.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class ModCommands {
	public static void init(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("randommemes")
				.then(CommandManager.literal("scale")
								.then(CommandManager.argument("scale", FloatArgumentType.floatArg())
												.executes(context -> {
													float scale = FloatArgumentType.getFloat(context, "scale");
													return scaleUp(context.getSource(), scale);
												})
								)
		));
	}

	private static int scaleUp(ServerCommandSource source, float scale) {
		if (scale > 100 || scale < 0.1)
			return 0;

		// Run command `/attribute @s minecraft:generic.scale base set {scale}`
		// This will scale the player up by the specified amount
		CommandManager cmdman = source.getServer().getCommandManager();
		cmdman.executeWithPrefix(source, "attribute @s minecraft:generic.scale base set " + scale);
		cmdman.executeWithPrefix(source, "attribute @s minecraft:generic.movement_speed base set " + scale);
		cmdman.executeWithPrefix(source, "attribute @s minecraft:player.block_interaction_range base set " + scale);
		cmdman.executeWithPrefix(source, "attribute @s minecraft:player.entity_interaction_range base set " + scale);
		cmdman.executeWithPrefix(source, "attribute @s minecraft:generic.step_height base set " + scale);

		// Clear the chat
		ServerPlayerEntity player = source.getPlayer();
		for (int i = 0; i < 100; i++) {
			assert player != null;
			player.sendMessage(Text.of(""), false);
		}

		source.sendMessage(Text.of("Size changed to " + scale + "!"));

		return 1;
	}
}
