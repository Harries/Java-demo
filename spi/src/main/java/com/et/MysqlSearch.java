package com.et;

public class MysqlSearch implements SearchService{

    @Override
    public String search(String key) {
        return "��Mysql��search" + key + "��result��No";
    }
}
