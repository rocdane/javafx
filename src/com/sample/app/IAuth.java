package com.sample.app;

import com.sample.models.User;

public interface IAuth {

    User signIn(User user);

    void signOut();
}
