package com.hillel.webapp.filmlibrary.user;

public enum Role {
    ADMIN(1), USER(2);

    private int role;

    Role(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public static Role byNumber(int userRole) {
        return userRole == 1 ? ADMIN : USER;
    }
}