package com.xhomerly.abstraktniobrazek;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

public class HelloController {
    @FXML TextField textField;
    @FXML Canvas mainCanvas;
    GraphicsContext gc;
    ArrayList<Double> middlesX = new ArrayList<>(), middlesY = new ArrayList<>();

    public void initialize() {
        gc = mainCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
    }

    public void delete() {
        gc.clearRect(0, 0, mainCanvas.getWidth(), mainCanvas.getHeight());
        middlesX.clear();
        middlesY.clear();
    }

    public void create() {
        int numOfLines = Integer.parseInt(textField.getText());
        System.out.println(numOfLines);
        for (int i = 0; i < numOfLines; i++) {
            int randX1 = (int) (Math.random() * 500);
            int randX2 = (int) (Math.random() * 500);
            int randY1 = (int) (Math.random() * 500);
            int randY2 = (int) (Math.random() * 500);

            double middleX = (double) (randX1 + randX2) /2;
            double middleY = (double) (randY1 + randX2) /2;

            middlesX.add(middleX);
            middlesY.add(middleY);

            gc.strokeLine(randX1, randX2, randY1, randY2);
        }

        gc.stroke();
    }

    public void graphX() {
        Stage stage = new Stage();
        stage.setTitle("Graph X");

        VBox root = new VBox();
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        for (int i = 0; i < middlesX.size(); i++) {
            series.getData().add(new XYChart.Data<>(middlesX.get(i), middlesY.get(i)));
        }

        lineChart.getData().add(series);

        root.getChildren().add(lineChart);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void graphY() {
        Stage stage = new Stage();
        stage.setTitle("Graph Y");

        VBox root = new VBox();
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        for (int i = 0; i < middlesX.size(); i++) {
            series.getData().add(new XYChart.Data<>(middlesX.get(i), middlesY.get(i)));
        }

        lineChart.getData().add(series);

        root.getChildren().add(lineChart);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}