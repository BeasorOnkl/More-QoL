package fr.idarkay.morefeatures.options;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.MutableText;

@Environment(EnvType.CLIENT)
public abstract class Option {
    protected final MutableText prefix;

    protected Option(MutableText prefix) {
        this.prefix = prefix;
    }

    public abstract ClickableWidget createButton(FeaturesGameOptions options, int x, int y, int width);

    public MutableText getDisplayPrefix() {
        return prefix;
    }
}
