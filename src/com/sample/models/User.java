package com.sample.models;

import java.util.HashMap;

public class User {
    private long id;
    private HashMap credential;
    private Role role;

    public User(String username,String password) {
        credential = new HashMap();
        this.credential.put("username",username);
        this.credential.put("password",password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HashMap getCredential(){
        return this.credential;
    }

    public void setCredential(HashMap credential) {
        this.credential = credential;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}