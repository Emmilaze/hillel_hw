package com.hillel.webapp.service.impl;

import com.hillel.webapp.filmlibrary.db.DataBaseQueries;
import com.hillel.webapp.filmlibrary.user.User;
import com.hillel.webapp.service.UserService;

public class UserManager implements UserService {
    private DataBaseQueries db;

    public UserManager() {
        db = DataBaseQueries.getInstance();
    }

    @Override
    public User getUser(String username) {
        return db.findUserByUsername(username);
    }
}
