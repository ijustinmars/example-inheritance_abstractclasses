package org.jhidalgo.pooabstractsclasses.form.elements.select;

public class OptionC {
    private String value;
    private String name;
    private boolean selected;

    public OptionC() {
    }

    public OptionC(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public OptionC setSelected() {
        this.selected = true;
        return this;
    }
}
