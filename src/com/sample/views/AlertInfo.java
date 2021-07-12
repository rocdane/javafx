package com.sample.views;

import javafx.scene.control.Alert;

public class AlertInfo extends Alert {
    private static AlertInfo alert;

    private AlertInfo() {
        super(AlertType.INFORMATION);
    }

    public static Alert getInstance(){
        if(alert==null){
            alert = new AlertInfo();
        }
        return alert;
    }
}
