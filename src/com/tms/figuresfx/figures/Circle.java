package com.tms.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Figure {

    private double radius;

    private Circle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_CIRCLE, cx, cy, lineWidth, color);
    }

    public Circle(double cx, double cy, double lineWidth, Color color, double radius){
        this(cx, cy, lineWidth, color);
        this.radius = radius < 30 ? 30 : radius;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(color);
        graphicsContext.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2 );
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
        return "Circle{" +
                "radius=" + radius +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }
}
