package com.et;

public class UserLoginListener implements EventListener<UserLoginEvent> {
    @Override
    public void onEvent(UserLoginEvent event) {
        System.out.println("User logged in: " + event.getUsername());
    }
}
