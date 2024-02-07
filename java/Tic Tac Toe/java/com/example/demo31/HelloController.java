package com.example.demo31;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;



public class HelloController  {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onStartButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page2.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        stage.setScene(scene2);
    }



}