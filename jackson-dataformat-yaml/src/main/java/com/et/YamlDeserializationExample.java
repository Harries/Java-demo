package com.et;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlDeserializationExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        Company company = mapper.readValue(new File("D:\\IdeaProjects\\Java-demo\\jackson-dataformat-yaml\\src\\main\\resources\\employee.yaml"), Company.class);
        company.getEmployees().forEach(row_ -> System.out.println(row_.getName() + " " + row_.getAge() + " " ));
    }
}