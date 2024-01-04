package com.mohistmc.forge.addon;

import com.google.common.eventbus.EventBus;
import com.mohistmc.MohistMC;
import com.mohistmc.forge.CustomMod;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.MetadataCollection;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class MohistMod extends DummyModContainer implements CustomMod {

    public MohistMod(InputStream inputStream) {
        super(MetadataCollection.from(inputStream, "Mohist").getMetadataForId("mohist", null));
        is.add(modinfo());
    }

    public static InputStream modinfo() {
        String info = "[\n" +
                "{\n" +
                "  \"modid\": \"mohist\",\n" +
                "  \"name\": \"Mohist\",\n" +
                "  \"description\": \"Mohist built-in mark.\",\n" +
                "  \"version\": \"" + MohistMC.getVersion() + "\",\n" +
                "  \"mcversion\": \"1.12.2\",\n" +
                "  \"logoFile\": \"/mohist_logo.png\",\n" +
                "  \"url\": \"https://mohistmc.com/\",\n" +
                "  \"updateUrl\": \"\",\n" +
                "  \"authors\": [\"MohistMC\"],\n" +
                "  \"credits\": \"Made by MohistMC\",\n" +
                "  \"parent\": \"\",\n" +
                "  \"screenshots\": [],\n" +
                "  \"dependencies\": []\n" +
                "}\n" +
                "]";
        return new ByteArrayInputStream(info.getBytes());
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        return true;
    }

    @Override
    public Disableable canBeDisabled() {
        return Disableable.YES;
    }

    @Override
    public File jarFile() {
        return new File("mohist.jar");
    }
}
