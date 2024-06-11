package org.jhidalgo.pooabstractsclasses.form.validator;

public class EmailValidator extends Validator{
    protected String text = "formato del email es invalido";
    private final static String EMAIL_REGEX = "^(.+)@(.+)$";

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
        return value.matches(EMAIL_REGEX);
    }
}
