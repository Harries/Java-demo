package com.et;

import com.jayway.jsonpath.JsonPath;
import java.util.List;

public class JsonPathExample {
    public static void main(String[] args) {
        String jsonString = "{ \"store\": { \"book\": [ { \"category\": \"fiction\", \"title\": \"The Great Gatsby\", \"price\": 10.99 }, { \"category\": \"non-fiction\", \"title\": \"Sapiens\", \"price\": 15.99 } ], \"bicycle\": { \"color\": \"red\", \"price\": 19.95 } } }";

        // Extract all book titles
        List<String> titles = JsonPath.read(jsonString, "$.store.book[*].title");
        System.out.println("Book Titles: " + titles);

        // Extract books with a price less than 15
        List<Object> cheapBooks = JsonPath.read(jsonString, "$.store.book[?(@.price < 15)]");
        System.out.println("Cheap Books: " + cheapBooks);

        // Extract all prices in the store
        List<Double> prices = JsonPath.read(jsonString, "$.store..price");
        System.out.println("Prices: " + prices);
    }
}