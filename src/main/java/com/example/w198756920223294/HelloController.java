package com.example.w198756920223294;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class HelloController extends Main{
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextField enterName;

    @FXML
    private Circle Cus11;

    @FXML
    private Circle Cus12;

    @FXML
    private Circle Cus21;

    @FXML
    private Circle Cus22;

    @FXML
    private Circle Cus23;

    @FXML
    private Circle Cus31;

    @FXML
    private Circle Cus32;

    @FXML
    private Circle Cus33;

    @FXML
    private Circle Cus34;

    @FXML
    private Circle Cus35;

    @FXML
    private TextField possNo;

    @FXML
    private TextField queueNO;

    @FXML
    private TextArea result_Space;

    @FXML
    private TextField search_cus;

    @FXML
    private TextField total_space;

    @FXML
    private TextArea displayView;

    @FXML
    private TextField waiting_Space;


    @FXML
    void LoadHandler(ActionEvent event) {


        try {
            queueNO.setText(String.valueOf(waiting.size()));
            possNo.setText(String.valueOf(totalCustomers));

            if(Queue1.getCashier().get(0) != null){
                Cus11.setStyle("-fx-fill : yellow");
            }
            if(Queue2.getCashier().get(0) != null){
                Cus21.setStyle("-fx-fill : yellow");
            }
            if(Queue3.getCashier().get(0) != null){
                Cus31.setStyle("-fx-fill : yellow");
            }
            if(Queue1.getCashier().get(1) != null){
                Cus12.setStyle("-fx-fill : yellow");
            }
            if(Queue2.getCashier().get(1) != null){
                Cus22.setStyle("-fx-fill : yellow");
            }
            if(Queue3.getCashier().get(1) != null){
                Cus32.setStyle("-fx-fill : yellow");
            }
            if(Queue2.getCashier().get(2) != null){
                Cus23.setStyle("-fx-fill : yellow");
            }
            if(Queue3.getCashier().get(2) != null){
                Cus33.setStyle("-fx-fill : yellow");
            }
            if(Queue3.getCashier().get(3) != null){
                Cus34.setStyle("-fx-fill : yellow");
            }
            if(Queue3.getCashier().get(4) != null){
                Cus35.setStyle("-fx-fill : yellow");
            }


        }catch (Exception e){
            System.out.println();
        }
    }



    @FXML
    void searchLoader(ActionEvent event) {
        String input = enterName.getText().toUpperCase();
        StringBuilder names = new StringBuilder();

        boolean matchFound = false;

        for (int i = 0; i < Queue1.getCashier().size(); i++) {
            if (Objects.equals(input, Queue1.getCashier().get(i).getFirstName())) {
                names.append(Queue1.getCashier().get(i).getFirstName())
                        .append(" ")
                        .append(Queue1.getCashier().get(i).getLastName())
                        .append(" = ")
                        .append(Queue1.getCashier().get(i).getBurgers())
                        .append(System.lineSeparator())
                        .append("User at the Queue 1");
                matchFound = true;
            }
        }

        for (int i = 0; i < Queue2.getCashier().size(); i++) {
            if (Objects.equals(input, Queue2.getCashier().get(i).getFirstName())) {
                names.append(Queue2.getCashier().get(i).getFirstName())
                        .append(" ")
                        .append(Queue2.getCashier().get(i).getLastName())
                        .append(" = ")
                        .append(Queue2.getCashier().get(i).getBurgers())
                        .append(System.lineSeparator())
                        .append("User at the Queue 2");
                matchFound = true;
            }
        }

        for (int i = 0; i < Queue3.getCashier().size(); i++) {
            if (Objects.equals(input, Queue3.getCashier().get(i).getFirstName())) {
                names.append(Queue3.getCashier().get(i).getFirstName())
                        .append(" ")
                        .append(Queue3.getCashier().get(i).getLastName())
                        .append(" = ")
                        .append(Queue3.getCashier().get(i).getBurgers())
                        .append(System.lineSeparator())
                        .append("User at the Queue 3");
                matchFound = true;
            }
        }

        if (!matchFound) {
            names.append("User Not Found");
        }

        displayView.setText(names.toString());

    }
}

