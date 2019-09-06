package ru.nemek.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import ru.nemek.entities.Position;
import ru.nemek.service.PositionService;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;

@ComponentScan(basePackages = "ru.nemek.service")
public class PositionEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text.equals("")){
            setValue(null);
            return;
        }
        Position position = new Position();
        position.setId(Integer.parseInt(text));
        setValue(position);
    }

}
