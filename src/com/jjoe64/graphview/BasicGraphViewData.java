package com.jjoe64.graphview;

public class BasicGraphViewData implements GraphViewData {

    public final double valueX;
    public final double valueY;

    public BasicGraphViewData(double valueX, double valueY) {
        this.valueX = valueX;
        this.valueY = valueY;
    }

    @Override
    public double getX() {
        return valueX;
    }

    @Override
    public double getY() {
        return valueY;
    }
}
