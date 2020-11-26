package org.bukkit.craftbukkit.v1_16_R3;

import java.util.HashMap;
import net.minecraft.block.SoundType;
import net.minecraft.block.SoundType;
import org.bukkit.Sound;
import org.bukkit.SoundGroup;

public class CraftSoundGroup implements SoundGroup {

    private final net.minecraft.block.SoundType handle;
    private static final HashMap<SoundType, CraftSoundGroup> SOUND_GROUPS = new HashMap<>();

    public static SoundGroup getSoundGroup(SoundType soundEffectType) {
        return SOUND_GROUPS.computeIfAbsent(soundEffectType, CraftSoundGroup::new);
    }

    private CraftSoundGroup(net.minecraft.block.SoundType soundEffectType) {
        this.handle = soundEffectType;
    }

    public net.minecraft.block.SoundType getHandle() {
        return handle;
    }

    @Override
    public float getVolume() {
        return getHandle().volume; // PAIL rename volume
    }

    @Override
    public float getPitch() {
        return getHandle().pitch; // PAIL rename pitch
    }

    @Override
    public Sound getBreakSound() {
        return CraftSound.getBukkit(getHandle().breakSound);
    }

    @Override
    public Sound getStepSound() {
        return CraftSound.getBukkit(getHandle().getStepSound()); // PAIL rename getStepSound
    }

    @Override
    public Sound getPlaceSound() {
        return CraftSound.getBukkit(getHandle().getPlaceSound()); // PAIL rename getPlaceSound
    }

    @Override
    public Sound getHitSound() {
        return CraftSound.getBukkit(getHandle().hitSound);
    }

    @Override
    public Sound getFallSound() {
        return CraftSound.getBukkit(getHandle().getFallSound()); // PAIL rename getFallSound
    }
}
