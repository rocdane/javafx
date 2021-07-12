package com.sample.utils;

import com.sample.app.IAuth;
import com.sample.models.User;

public class Auth implements IAuth {
    private static Auth auth;
    private Session session;

    public Auth(){
        session = new Session();
    }

    public static Auth getAuth() {
        if(auth==null){
            auth = new Auth();
            return auth;
        }
        return auth;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public User signIn(User user) {
        // TODO: 10/07/2021 implement user connexion

        if(user==null){
            auth.getSession().setTimer(300000);
            auth.getSession().start();

            try {
                auth.getSession().join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
        return null;
    }

    @Override
    public void signOut() {
        session.sessionDestroy();
    }
}
