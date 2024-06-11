package org.jhidalgo.pooabstractsclasses.form.validator;

abstract public class Validator {
    protected String text;
    abstract public  void setText(String text);
    abstract public String getText();
    abstract public boolean isValid(String value);
}
