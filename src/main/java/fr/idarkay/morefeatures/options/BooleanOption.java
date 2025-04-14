package fr.idarkay.morefeatures.options;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.function.*;

@Environment(EnvType.CLIENT)
public class BooleanOption extends Option {

    private final Predicate<FeaturesGameOptions> getter;
    private final BiConsumer<FeaturesGameOptions, Boolean> setter;

    protected BooleanOption(MutableText prefix, Predicate<FeaturesGameOptions> getter, BiConsumer<FeaturesGameOptions, Boolean> setter) {
        super(prefix);
        this.getter = getter;
        this.setter = setter;
    }

    public void set(FeaturesGameOptions options, boolean value) {
        setter.accept(options, value);
        options.writeChanges();
    }

    public void set(FeaturesGameOptions options) {
        set(options, !get(options));
    }

    public boolean get(FeaturesGameOptions options) {
        return getter.test(options);
    }

    @Override
    public ClickableWidget createButton(FeaturesGameOptions options, int x, int y, int width) {
        ButtonWidget.Builder builder = ButtonWidget.builder(getDisplayString(options), button ->
        {
            set(options);
            button.setMessage(getDisplayString(options));
        });
        builder.position(x, y);
        builder.width(width);
        return builder.build();
    }

    public Text getDisplayString(FeaturesGameOptions options) {
        return this.getDisplayPrefix().copy().append(ScreenTexts.onOrOff(this.get(options)));
    }

}
