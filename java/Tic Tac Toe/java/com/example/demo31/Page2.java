package com.example.demo31;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Page2 {
    @FXML
    Label label2 ;
    @FXML
    protected void onEnterButtonPressed(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page3.fxml"));
        try {
            Scene scene2 = new Scene(fxmlLoader.load());
            stage.setScene(scene2);
        } catch (IOException m) {
            m.printStackTrace();
        }
    }
}
