package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;


import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
public class PainterController {
    private int color;
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup identity;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (color == 1 && event.getX()>=0) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 5.0, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }else if(color == 0 && event.getX()>=0){
            Circle newCircle = new Circle(event.getX(), event.getY(), 5.0, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void chooseOption(ActionEvent event) {
        String button = ((RadioButton)event.getSource()).getText();
        if (button.equals("Pen")) {
            System.out.println("1");
            color = 1;
        }else {
            System.out.println("0");
            color = 0;
        }
    }

}