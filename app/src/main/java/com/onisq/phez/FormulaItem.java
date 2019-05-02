package com.onisq.phez;

public class FormulaItem {
    private String theme;
    private String definition;
    private String formula;

    public FormulaItem(String theme, String definition, String formula){
        this.theme = theme;
        this.definition = definition;
        this.formula = formula;
    }

    public String getTheme() {  
        return theme;
    }

    public String getDefinition() {
        return definition;
    }

    public String getFormula() {
        return formula;
    }
}
