package org.jhidalgo.pooabstractsclasses.form.validator;

import jdk.jfr.TransitionFrom;
import org.jhidalgo.pooabstractsclasses.form.validator.text.FormattableText;

public class LongValidator extends Validator implements FormattableText {
    protected String text = "el campo %s debe tener minimo %d caracteres y maximo %d caracteres";
    private int min;
    private int max = Integer.MAX_VALUE;

    public LongValidator() {
    }

    public LongValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

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
        //this.text = String.format(this.text, this.min, this.max);
        if (value == null){
            return true;
        }
        int l = value.length();
        return (l >= min && l <= max);
    }

    @Override
    public String getTextFormat(String c) {
        return String.format(this.text, c, this.min, this.max);
    }
}
