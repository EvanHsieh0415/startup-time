package icu.takeneko.startup_time.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;

public class TranslationProvider extends FabricLanguageProvider {

    private final String lang;

    public TranslationProvider(FabricDataOutput dataOutput, String lang) {
        super(dataOutput, lang);
        this.lang = lang;
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/startup_time/lang/%s.json".formatted(lang)).get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
