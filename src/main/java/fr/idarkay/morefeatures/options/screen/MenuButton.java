package fr.idarkay.morefeatures.options.screen;

import fr.idarkay.morefeatures.options.FeaturesGameOptions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public class MenuButton {

    private final Text name;
    private final BiFunction<Screen, FeaturesGameOptions, Screen> creator;

    public MenuButton(Text name, BiFunction<Screen, FeaturesGameOptions, Screen> creator) {
        this.name = name;
        this.creator = creator;
    }

    public ClickableWidget createButton(@Nullable Screen parent, FeaturesGameOptions options, int x, int y, int width) {
        ButtonWidget.Builder builder = ButtonWidget.builder(this.name, button ->
                MinecraftClient.getInstance().setScreen(creator.apply(parent, options)));
        return builder.position(x, y).width(width).build();
    }

}
