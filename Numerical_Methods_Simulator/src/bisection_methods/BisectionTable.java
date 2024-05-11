package bisection_methods;

import javafx.beans.property.SimpleDoubleProperty;

public class BisectionTable {
    
    private final SimpleDoubleProperty column_Iteration1, column_xL1, column_xM1, 
            column_xU1, column_FxL1, column_FxM1, column_FxU1, column_Ea1;
   
    public BisectionTable(Double column_Iteration1, Double column_xL1, Double column_xM1,
            Double column_xU1, Double column_FxL1, Double column_FxM1, Double column_FxU1, Double column_Ea1) {
        this.column_Iteration1 = new SimpleDoubleProperty(column_Iteration1);
        this.column_xL1 = new SimpleDoubleProperty(column_xL1);
        this.column_xM1 = new SimpleDoubleProperty(column_xM1);
        this.column_xU1 = new SimpleDoubleProperty(column_xU1);
        this.column_FxL1 = new SimpleDoubleProperty(column_FxL1);
        this.column_FxM1 = new SimpleDoubleProperty(column_FxM1);
        this.column_FxU1 = new SimpleDoubleProperty(column_FxU1);
        this.column_Ea1 = new SimpleDoubleProperty(column_Ea1);
    }

    public Double getColumn_Iteration1() {
        return column_Iteration1.get();
    }

    public Double getColumn_xL1() {
        return column_xL1.get();
    }

    public Double getColumn_xM1() {
        return column_xM1.get();
    }

    public Double getColumn_xU1() {
        return column_xU1.get();
    }

    public Double getColumn_FxL1() {
        return column_FxL1.get();
    }

    public Double getColumn_FxM1() {
        return column_FxM1.get();
    }

    public Double getColumn_FxU1() {
        return column_FxU1.get();
    }

    public Double getColumn_Ea1() {
        return column_Ea1.get();
    }
            
    
}
