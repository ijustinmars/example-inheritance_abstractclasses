package org.jhidalgo.pooabstractsclasses.form.elements;

import org.jhidalgo.pooabstractsclasses.form.validator.LongValidator;
import org.jhidalgo.pooabstractsclasses.form.validator.Validator;
import org.jhidalgo.pooabstractsclasses.form.validator.text.FormattableText;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementForm {
    protected String value;
    protected String name;
    private List<Validator> validatorList;
    private List<String> errors;

    public ElementForm() {
        this.validatorList = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public ElementForm(String name) {
        this();
        this.name = name;
    }

    public ElementForm addValidator(Validator validator){
        this.validatorList.add(validator);
        return this;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isValid(){
        for(Validator v:this.validatorList){
            if(!v.isValid(this.value)){
                if (v instanceof FormattableText){
                    this.errors.add(((FormattableText) v).getTextFormat(name));
                }else{
                    this.errors.add(String.format(v.getText(), name));
                }
            }
        }
        return this.errors.isEmpty();
    }

    abstract public String paintHtml();

}
