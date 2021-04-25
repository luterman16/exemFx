package com.tms.figuresfx.drawutils;

import com.tms.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer <T extends Figure & Drawable> {
    ArrayList<T> figures = new ArrayList<>();

    public Drawer(ArrayList<T> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext gc) {
        for (Figure f : figures){
            f.draw(gc);
        }
    }
}
