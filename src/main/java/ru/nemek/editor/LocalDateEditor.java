package ru.nemek.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Date;

public class LocalDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        if(text.equals(""))
            setValue(null);
        else
            setValue(LocalDate.parse(text));
    }

    @Override
    public String getAsText() {

        return  "0";
    }
}
