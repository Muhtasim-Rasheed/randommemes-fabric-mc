package randommemes.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import randommemes.RandomMemes;

public class ModSounds {
	public static final SoundEvent PORTAL_RADIO = register("portal_radio");
	public static final RegistryKey<JukeboxSong> PORTAL_RADIO_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(RandomMemes.MOD_ID, "portal_radio"));
	public static final SoundEvent FUNKY_TOWN = register("funky_town");
	public static final RegistryKey<JukeboxSong> FUNKY_TOWN_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(RandomMemes.MOD_ID, "funky_town"));

	private static SoundEvent register(String name) {
		return Registry.register(Registries.SOUND_EVENT, Identifier.of(RandomMemes.MOD_ID, name), SoundEvent.of(Identifier.of(RandomMemes.MOD_ID, name)));
	}

	public static void init() {
		// Nothing
	}
}
