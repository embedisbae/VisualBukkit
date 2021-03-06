package us.donut.visualbukkit.blocks.syntax;

import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import org.bukkit.configuration.ConfigurationSection;

public class InputParameter extends TextField implements BlockParameter {

    public InputParameter() {
        setFont(Font.font("consolas", 12));
        prefColumnCountProperty().bind(textProperty().length().add(1));
    }

    @Override
    public String toJava() {
        return getText();
    }

    @Override
    public void unload(ConfigurationSection section) {
        section.set("value", getText());
    }

    @Override
    public void load(ConfigurationSection section) {
        setText(section.getString("value"));
    }
}
