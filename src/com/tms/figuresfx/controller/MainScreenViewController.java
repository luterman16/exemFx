package com.tms.figuresfx.controller;

import com.tms.figuresfx.drawutils.Drawer;
import com.tms.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private ArrayList<Figure> figures = new ArrayList<>();
    private Random random;
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
        }

    private Figure createFigure(double x, double y) throws UnknownFigureException {
        Figure figure = null;
        switch (random.nextInt(4)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(3), Color.GREEN, random.nextInt(3));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(3), Color.AQUA, random.nextInt(60), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Trianlge(x, y, random.nextInt(3), Color.DARKBLUE);
                break;
            case Figure.FIGURE_TYPE_STAR:
                figure = new Star(x, y, random.nextInt(3), Color.FIREBRICK);
                break;
            default:
                throw new UnknownFigureException("Такой фигуры нет");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMousedClicked(MouseEvent mouseEvent)  {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (UnknownFigureException e) {
            logger.error(e.getMessage(), e);
        }
        repaint();
    }
}
