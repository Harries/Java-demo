package com.et;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class CSVExample {

    public static void main(String[] args) {
        String[] headers = {"Name", "Age", "Email"};
        String csvFile = "D://tmp/example.csv";

        // write CSV file
        try (FileWriter writer = new FileWriter(csvFile);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers))) {

            csvPrinter.printRecord("John Doe", 30, "john.doe@example.com");
            csvPrinter.printRecord("Jane Smith", 25, "jane.smith@example.com");

            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read CSV file
        try (Reader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(headers).withSkipHeaderRecord())) {

            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get("Name");
                String age = csvRecord.get("Age");
                String email = csvRecord.get("Email");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
                System.out.println("---------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}