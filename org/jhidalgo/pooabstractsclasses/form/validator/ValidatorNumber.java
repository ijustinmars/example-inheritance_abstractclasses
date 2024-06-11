package org.jhidalgo.pooabstractsclasses.form.validator;

public class ValidatorNumber extends Validator{
    protected String text = "el campo %s debe ser numero";

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
        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
