package falseposition_methods;

import javafx.beans.property.SimpleDoubleProperty;


public class FalsePositionTable {
    
    private final SimpleDoubleProperty column_Iteration2, column_xL2, column_xM2, 
            column_xU2,column_FxL2, column_FxM2, column_FxU2, column_Ea2;

    public FalsePositionTable(Double column_Iteration2, Double column_xL2, Double column_xM2, 
            Double column_xU2, Double column_FxL2, Double column_FxM2, Double column_FxU2, Double column_Ea2) {
        this.column_Iteration2 = new SimpleDoubleProperty(column_Iteration2);
        this.column_xL2 = new SimpleDoubleProperty(column_xL2);
        this.column_xM2 = new SimpleDoubleProperty(column_xM2);
        this.column_xU2 = new SimpleDoubleProperty(column_xU2);
        this.column_FxL2 = new SimpleDoubleProperty(column_FxL2);
        this.column_FxM2 = new SimpleDoubleProperty(column_FxM2);
        this.column_FxU2 = new SimpleDoubleProperty(column_FxU2);
        this.column_Ea2 = new SimpleDoubleProperty(column_Ea2);
    }

    public Double getColumn_Iteration2() {
        return column_Iteration2.get();
    }

    public Double getColumn_xL2() {
        return column_xL2.get();
    }

    public Double getColumn_xM2() {
        return column_xM2.get();
    }

    public Double getColumn_xU2() {
        return column_xU2.get();
    }

    public Double getColumn_FxL2() {
        return column_FxL2.get();
    }

    public Double getColumn_FxM2() {
        return column_FxM2.get();
    }

    public Double getColumn_FxU2() {
        return column_FxU2.get();
    }

    public Double getColumn_Ea2() {
        return column_Ea2.get();
    }
    
}
