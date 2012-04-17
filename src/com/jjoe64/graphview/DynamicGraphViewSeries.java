package com.jjoe64.graphview;

import java.util.Iterator;
import java.util.LinkedList;

public class DynamicGraphViewSeries extends GraphViewSeries {

    private final LinkedList<GraphViewData> values;

    public DynamicGraphViewSeries() {
        super();

        values = new LinkedList<GraphViewData>();
    }

    public DynamicGraphViewSeries(LinkedList<GraphViewData> values) {
        super();

        this.values = values;
        findOutliers();
    }

    public DynamicGraphViewSeries(String description) {
        super(description);

        values = new LinkedList<GraphViewData>();
    }

    public DynamicGraphViewSeries(String description, LinkedList<GraphViewData> values) {
        super(description);
        this.values = values;
        findOutliers();
    }

    public DynamicGraphViewSeries(String description, int color) {
        super(description, color);

        values = new LinkedList<GraphViewData>();
    }

    public DynamicGraphViewSeries(String description, int color, LinkedList<GraphViewData> values) {
        super(description, color);
        this.values = values;
        findOutliers();
    }

    public void addDataPoint(GraphViewData data) {
        this.values.add(data);
        findOutliers();
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public Iterator<GraphViewData> getIterator() {
        return values.iterator();
    }

    @Override
    public Iterator<GraphViewData> getIterator(int start) {
        return values.listIterator(start);
    }

}
