package com.et;

public class RedisSearch implements SearchService{

    @Override
    public String search(String key) {
        return "��Redis��search" + key + "��result��Yes";
    }
}
