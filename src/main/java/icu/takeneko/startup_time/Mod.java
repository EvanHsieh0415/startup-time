package icu.takeneko.startup_time;

import icu.takeneko.startup_time.datagen.TranslationProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataGenerator;

public class Mod implements ClientModInitializer, DataGeneratorEntrypoint {

    @Override
    public void onInitializeClient() {

    }

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        ((DataGenerator.Pack)pack).addProvider(output -> new TranslationProvider((FabricDataOutput) output, "zh_cn"));
        ((DataGenerator.Pack)pack).addProvider(output -> new TranslationProvider((FabricDataOutput) output, "en_us"));
    }
}