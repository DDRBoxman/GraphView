package com.jjoe64.graphview;

import java.util.Iterator;

public abstract class GraphViewSeries {

    private final String description;
    private final int color;
    private double minX = 0;
    private double minY = 0;
    private double maxX = 0;
    private double maxY = 0;

    public GraphViewSeries() {
         this(null);
    }

    public GraphViewSeries(String description) {
        this(description, 0xff0077cc);
    }

    public GraphViewSeries(String description, Integer color) {
        this.description = description;
        if (color == null) {
            color = 0xff0077cc; // blue version
        }
        this.color = color;
    }

    protected void findOutliers() {

        boolean first = true;
        for (Iterator<GraphViewData> dataIterator = getIterator(); dataIterator.hasNext();)
        {
            GraphViewData data = dataIterator.next();
            if (first) {
                minX = data.valueX;
                minY = data.valueY;
                first = false;
            }

            minX = Math.min(data.valueX, minX);
            minY = Math.min(data.valueY, minY);
            maxX = Math.max(data.valueX, maxX);
            maxY = Math.max(data.valueY, maxY);
        }
    }

    public String getDescription() {
        return description;
    }

    public int getColor() {
        return color;
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public abstract int getSize();
    public abstract Iterator<GraphViewData> getIterator();
    public abstract Iterator<GraphViewData> getIterator(int start);
}
