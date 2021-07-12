package com.sample.controllers;

import com.sample.models.Role;
import com.sample.models.User;
import com.sample.utils.Auth;
import com.sample.views.AlertError;
import com.sample.views.AlertWarning;
import com.sample.views.Gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.sample.views.AlertInfo;
import java.io.IOException;
import java.util.HashMap;

public class AuthController extends Auth {

    private HashMap<String,String> credential = new HashMap<String,String>();

    public HashMap<String, String> getCredential() {
        return credential;
    }

    public void setCredential(HashMap<String, String> credential) {
        this.credential = credential;
    }

    @FXML private TextField username;

    @FXML private PasswordField password;

    @FXML private Button login;

    @FXML void forgetPassword(){
        AlertInfo.getInstance().setTitle("Mot de passe oublié");
        AlertInfo.getInstance().setContentText("Veuillez contacter le fournisseur pour obtenir un mot de passe \n contact : (+229)62773300");
        AlertInfo.getInstance().show();
    }

    @FXML void login(ActionEvent event) {
        User user = new User(
                username.getText().trim(),
                password.getText().trim()
        );

        if(this.signIn(user)==null){
            AlertError.getInstance().setTitle("Erreur d'authentification");
            AlertError.getInstance().setContentText("Nom d'utilisateur ou mot de passe incorrect");
            AlertError.getInstance().showAndWait();
        }else{
            Parent root = null;

            Role ROLE = user.getRole();

            switch (ROLE){
                case ADMIN:
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
                        Gui.getGui().setTitle("APP NAME | Admin");
                        Gui.getGui().setScene(new Scene(root,1200,600));
                        Gui.getGui().centerOnScreen();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    AlertWarning.getInstance().setTitle("Erreur d'authentification");
                    AlertWarning.getInstance().setContentText("utilisateur non autorisé");
                    AlertWarning.getInstance().showAndWait();
                    break;
            }
        }
    }
}