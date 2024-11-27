package com.et;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaExample {
    public static void main(String[] args) {
        // Create MapperFactory
        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        // Get MapperFacade
        MapperFacade mapper = mapperFactory.getMapperFacade();

        // Define source object
        SourceObject source = new SourceObject();
        source.setId(1);
        source.setName("John Doe");

        // Perform mapping
        DestinationObject destination = mapper.map(source, DestinationObject.class);

        // Output results
        System.out.println("Destination ID: " + destination.getId());
        System.out.println("Destination Name: " + destination.getName());
    }
}