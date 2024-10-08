package com.et;

public class MysqlSearch implements SearchService{

    @Override
    public String search(String key) {
        return "¡¾Mysql¡¿search" + key + "£¬result£ºNo";
    }
}
