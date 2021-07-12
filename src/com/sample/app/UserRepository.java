package com.sample.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.sample.models.User;


public class UserRepository {

    private static UserRepository instance;

    private ObservableList<User> users = FXCollections.observableArrayList();

    private UserRepository(){

    }

    public static UserRepository getInstance(){
        if(instance==null){
            instance = new UserRepository();
        }
        return instance;
    }


    public void create(User user){
        // TODO: 08/07/2021 add new user
    }

    public ObservableList<User> getUsers() {
        // TODO: 08/07/2021 get user info
        return null;
    }

    public void showUsers(){
        ObservableList<User> users = getUsers();
    }
}
