package com.mycompany.calcengine;

public class Subtracter extends CalculateBase {
    @Override
    public void calculate() {
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }
}
