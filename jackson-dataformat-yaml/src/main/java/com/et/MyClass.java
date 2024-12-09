package com.et;

class MyClass {
    private String name;
    private int value;

    
    public MyClass(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // Getter ºÍ Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}