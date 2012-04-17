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
                minX = data.getX();
                minY = data.getY();
                first = false;
            }

            minX = Math.min(data.getX(), minX);
            minY = Math.min(data.getY(), minY);
            maxX = Math.max(data.getX(), maxX);
            maxY = Math.max(data.getY(), maxY);
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
