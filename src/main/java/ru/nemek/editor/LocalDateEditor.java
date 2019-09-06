package ru.nemek.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Date;

public class LocalDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text)  throws IllegalArgumentException {
        if(text.equals(""))
            setValue(null);
        else
            setValue(LocalDate.parse(text));
    }

}
