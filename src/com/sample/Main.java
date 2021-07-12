package com.sample;

import com.sample.views.Gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent primary = FXMLLoader.load(getClass().getResource("/fxml/auth.fxml"));

        Gui.getGui().setTitle("APP NAME | Se connecter");
        Gui.getGui().setScene(new Scene(primary));
        Gui.getGui().getIcons().add(new Image("/img/logo.png"));
        Gui.getGui().centerOnScreen();
        Gui.getGui().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
