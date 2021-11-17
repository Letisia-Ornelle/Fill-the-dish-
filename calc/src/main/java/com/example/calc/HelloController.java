package com.example.calc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.AccessibleAction;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {


    float number1 = 0;
    float number2 = 0;
    int operation = 0;
    float answer = 0;
    @FXML
    Button b0;
    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    Button b9;
    @FXML
    Button badd;
    @FXML
    Button bmul;
    @FXML
    Button beq;
    @FXML
    Button bdiv;
    @FXML
    Button bsub;

    @FXML
    TextField tf;
    @FXML
    Button bclear;


    public void buttonActions(ActionEvent actionEvent) {
        if (actionEvent.getSource() == b1) {
            tf.setText(tf.getText() + "1");
        }
        if (actionEvent.getSource() == b0) {
            tf.setText(tf.getText() + "0");
        }
        if (actionEvent.getSource() == b2) {
            tf.setText(tf.getText() + "2");
        }

        if (actionEvent.getSource() == b3) {
            tf.setText(tf.getText() + "3");
        }
        if (actionEvent.getSource() == b4) {
            tf.setText(tf.getText() + "4");
        }
        if (actionEvent.getSource() == b5) {
            tf.setText(tf.getText() + "5");
        }
        if (actionEvent.getSource() == b6) {
            tf.setText(tf.getText() + "6");
        }
        if (actionEvent.getSource() == b7) {
            tf.setText(tf.getText() + "7");
        }
        if (actionEvent.getSource() == b8) {
            tf.setText(tf.getText() + "8");

        }
        if (actionEvent.getSource() == b9) {
            tf.setText(tf.getText() + "9");
        }
        if (actionEvent.getSource() == bclear) {
            tf.setText("");
        }
        if (actionEvent.getSource() == bmul) {
            number1 = Float.parseFloat(tf.getText());
            operation = 1;
            tf.setText("");
        }
        if (actionEvent.getSource() == bdiv) {
            number1 = Float.parseFloat(tf.getText());
            operation = 2;
            tf.setText("");
        }
        if (actionEvent.getSource() == bsub) {
            number1 = Float.parseFloat(tf.getText());
            operation = 3;
            tf.setText("");
        }
        if (actionEvent.getSource() == badd) {
            number1 = Float.parseFloat(tf.getText());
            operation = 4;
            tf.setText("");
        }
        if (actionEvent.getSource() == beq) {
            number2 = Float.parseFloat(tf.getText());

            switch( operation){

                case 1:
                    answer = number1 * number2;
                    tf.setText(String.valueOf(answer));
                    break;
                case 2:
                    answer = number1 / number2;
                    tf.setText(String.valueOf(answer));
                    break;
                case 3:
                    answer = number1 - number2;
                    tf.setText(String.valueOf(answer));
                    break;
                case 4:
                    answer = number1 + number2;
                    tf.setText(String.valueOf(answer));
                    break;

            }

        }


    }
}