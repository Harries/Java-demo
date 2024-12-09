package com.et;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlSerializationExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        MyClass myObject = new MyClass("example", 123);
        mapper.writeValue(new File("D:\\IdeaProjects\\Java-demo\\jackson-dataformat-yaml\\src\\main\\resources\\output.yaml"), myObject);
    }
}

