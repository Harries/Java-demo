package com.et;

// UserLoginEvent
public class UserLoginEvent extends Event {
    private final String username;

    public UserLoginEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

