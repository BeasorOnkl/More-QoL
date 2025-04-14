package fr.idarkay.morefeatures;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import fr.idarkay.morefeatures.options.screen.FeaturesOptionsScreen;

public class FeaturesModApiImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return FeaturesOptionsScreen::new;
    }
}
