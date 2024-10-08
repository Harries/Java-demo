package com.et;

public class RedisSearch implements SearchService{

    @Override
    public String search(String key) {
        return "¡¾Redis¡¿search" + key + "£¬result£ºYes";
    }
}
