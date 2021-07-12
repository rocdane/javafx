package com.sample.views;

import javafx.stage.Stage;

public class Gui extends Stage {

    private static Stage gui;

    private Gui(){
        gui.setMaximized(false);
        gui.setResizable(false);
        gui.centerOnScreen();
    }

    public static Stage getGui(){
        if(gui==null){
            gui = new Stage();
        }
        return gui;
    }
}
