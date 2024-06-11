package org.jhidalgo.pooabstractsclasses.form.validator;

public class ValidatorRequired extends Validator{
    protected String text = "el campo %s es requerido";

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public boolean isValid(String value) {
        return (value != null && value.length() > 0);
    }
}
