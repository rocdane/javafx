package com.sample.views;

import javafx.scene.control.Alert;

public class AlertWarning extends Alert {
    private static AlertWarning alert;

    private AlertWarning() {
        super(AlertType.WARNING);
    }

    public static Alert getInstance(){
        if(alert==null){
            alert = new AlertWarning();
        }
        return alert;
    }
}
