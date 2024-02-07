package com.example.demo31;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Page3 {
    @FXML
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9 ;
    @FXML
    Label myLabel;
    @FXML
    Label label2;
    ArrayList<Button> buttonList = new ArrayList<>();
    int c = 0;

    public void initialize() {
        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
        buttonList.add(b4);
        buttonList.add(b5);
        buttonList.add(b6);
        buttonList.add(b7);
        buttonList.add(b8);
        buttonList.add(b9);
    }

    Random rand = new Random();

    @FXML
    protected void buttonClicked(ActionEvent event) {
        c++;
        Button sourceButton = (Button) event.getSource();
        sourceButton.setText("X");
        sourceButton.setDisable(true);
        int f = 0;
        check c1 = new check("X", buttonList);
        Thread t1 = new Thread(c1);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (c1.res) {
            System.out.println("you won");
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page4.fxml"));
            try {
                Scene scene2 = new Scene(fxmlLoader.load());
                stage.setScene(scene2);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (c == 9) {
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page6.fxml"));
            try {
                Scene scene6 = new Scene(fxmlLoader.load());
                stage.setScene(scene6);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (f == 0) {
            if (c == 9) {
                break;
            }
            int t = rand.nextInt(8);
            if (!buttonList.get(t).isDisable()) {
                buttonList.get(t).setText("0");
                buttonList.get(t).setDisable(true);
                c++;
                f = 1;
                check c2 = new check("0", buttonList);
                Thread t2 = new Thread(c2);
                t2.start();
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c2.res) {
                    System.out.println("you lost");
                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page5.fxml"));
                    try {
                        Scene scene3 = new Scene(fxmlLoader.load());
                        stage.setScene(scene3);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
