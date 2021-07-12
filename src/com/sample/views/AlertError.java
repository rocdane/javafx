package com.sample.views;

import javafx.scene.control.Alert;

public class AlertError extends Alert {
    private static AlertError alert;

    private AlertError() {
        super(AlertType.ERROR);
    }

    public static Alert getInstance(){
        if(alert==null){
            alert = new AlertError();
        }
        return alert;
    }
}
