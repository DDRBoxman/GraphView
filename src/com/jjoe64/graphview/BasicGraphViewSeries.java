package com.jjoe64.graphview;

import org.apache.commons.collections.iterators.ArrayIterator;

import java.util.Iterator;


/**
 * a graph series
 */
public class BasicGraphViewSeries extends GraphViewSeries {

    private final GraphViewData[] values;

    public BasicGraphViewSeries(GraphViewData[] values) {
        super();
        this.values = values;
    }

    public BasicGraphViewSeries(String description, GraphViewData[] values) {
        super(description);
        this.values = values;
    }

    public BasicGraphViewSeries(String description, int color, GraphViewData[] values) {
        super(description, color);
        this.values = values;
    }

    @Override
    public int getSize() {
        return values.length;
    }

    @Override
    public Iterator<GraphViewData> getIterator() {
        return new ArrayIterator(values);
    }

    @Override
    public Iterator<GraphViewData> getIterator(int start) {
        return new ArrayIterator(values, start);
    }


}

