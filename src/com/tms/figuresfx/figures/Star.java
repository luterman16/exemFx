package com.tms.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star extends Figure {
    public Star(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_STAR, cx, cy, lineWidth, color);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(color);
        graphicsContext.strokePolygon(new double[]{cx-25, cx, cx + 25, cx -40, cx + 40}, new double[]{cy+30, cy-35, cy+30, cy-10, cy-10}, 5);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Star{" +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}
