package org.jhidalgo.pooabstractsclasses.form.elements;

import org.jhidalgo.pooabstractsclasses.form.elements.select.OptionC;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementForm{
    private List<OptionC> options;

    public SelectForm(String name) {
        super(name);
        this.options = new ArrayList<>();
    }

    public SelectForm(String name, List<OptionC> options) {
        super(name);
        this.options = options;
    }

    public SelectForm addOptionC(OptionC optionC){
        this.options.add(optionC);
        return this;
    }

    @Override
    public String paintHtml() {
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name='").append(this.name).append("'>");

        for(OptionC optionC:this.options){
            sb.append("\n<option value='")
                    .append(optionC.getValue())
                    .append("'");
            if (optionC.isSelected()){
                sb.append(" selected");
                this.value = optionC.getValue();
            }
            sb.append(">").append(optionC.getName())
                    .append("</option>");
        }
        sb.append("</select>");
        return sb.toString();
    }
}
