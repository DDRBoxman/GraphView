package com.jjoe64.graphview;

import android.content.Context;
import android.graphics.Canvas;

import java.util.Iterator;

/**
 * Draws a Bar Chart
 * @author Muhammad Shahab Hameed
 */
public class BarGraphView extends GraphView {
	public BarGraphView(Context context, String title) {
		super(context, title);
	}

	@Override
	public void drawSeries(Canvas canvas, GraphViewSeries values, float graphwidth, float graphheight,
			float border, double minX, double minY, double diffX, double diffY,
			float horstart) {
		float colwidth = (graphwidth - (2 * border)) / values.getSize();

        int pos = 0;

		// draw data
        for (Iterator<GraphViewData> dataIterator = values.getIterator(); dataIterator.hasNext();)
        {
            GraphViewData data = dataIterator.next();
			float valY = (float) (data.valueY - minY);
			float ratY = (float) (valY / diffY);
			float y = graphheight * ratY;
			canvas.drawRect((pos * colwidth) + horstart, (border - y) + graphheight, ((pos * colwidth) + horstart) + (colwidth - 1), graphheight + border - 1, paint);

            pos++;
		}
	}
}
