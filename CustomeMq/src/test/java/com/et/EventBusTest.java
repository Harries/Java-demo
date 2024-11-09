package com.et;

public class EventBusTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        
        // register
        UserLoginListener userLoginListener = new UserLoginListener();
        eventBus.register(UserLoginEvent.class, userLoginListener);
        
        // publish
        UserLoginEvent loginEvent = new UserLoginEvent("Alice");
        eventBus.post(loginEvent);
        
        // unregister
        eventBus.unregister(UserLoginEvent.class, userLoginListener);
        eventBus.post(new UserLoginEvent("Bob")); // don't take effort,because the event is unregister
    }
}
