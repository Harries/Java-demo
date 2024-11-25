package com.et;

// event listen interface
public interface EventListener<T extends Event> {
    void onEvent(T event);
}
