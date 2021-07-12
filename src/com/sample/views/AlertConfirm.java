package com.sample.views;

import javafx.scene.control.Alert;

public class AlertConfirm extends Alert {
    private static AlertConfirm alert;

    private AlertConfirm() {
        super(AlertType.CONFIRMATION);
    }

    public static Alert getInstance(){
        if(alert==null){
            alert = new AlertConfirm();
        }
        return alert;
    }
}
