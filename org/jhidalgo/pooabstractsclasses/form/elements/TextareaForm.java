package org.jhidalgo.pooabstractsclasses.form.elements;

public class TextareaForm extends ElementForm{
    private int row;
    private int columns;

    public TextareaForm(String name) {
        super(name);
    }

    public TextareaForm(String name, int row, int columns) {
        super(name);
        this.row = row;
        this.columns = columns;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    public String paintHtml() {
        return "<textarea name='" + this.name
                + "' cols='" + this.columns
                + "' rows='" + this.row + "'>"
                + this.value +"</textarea>";
    }
}
