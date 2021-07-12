package com.sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import com.sample.views.Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable{
    @FXML
    private Pane content;

    @FXML void versHome(ActionEvent event) {
        setContent("/view/home.fxml");
        Gui.getGui().setTitle("BABA BODY | Accueil");
    }

    @FXML void logout(ActionEvent event) {
        Parent auth = null;
        try {
            auth = FXMLLoader.load(getClass().getResource("/view/auth.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gui.getGui().setScene(new Scene(auth));
        Gui.getGui().centerOnScreen();
    }

    public void emptyContent(){
        content.getChildren().removeAll();
    }

    public void setContent(String view){
        emptyContent();
        try {
            Pane fxml = FXMLLoader.load(getClass().getResource(view));
            content.getChildren().add(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Gui.getGui().maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Gui.getGui().setMaximized(false);
            }
        });

        /*versHome.addEventHandler(ActionEvent.ACTION,event -> {
            setContent("/view/home.fxml");
            Gui.getGui().setTitle("APP NAME | Accueil");
        });*/
    }
}
