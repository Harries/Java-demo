package com.et;

public class MysqlSearch implements SearchService{

    @Override
    public String search(String key) {
        return "Mysqlsearch" + key + "result No";
    }
}
