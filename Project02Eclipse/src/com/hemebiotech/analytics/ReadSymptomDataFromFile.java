package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepathInput;

    public ReadSymptomDataFromFile(String filepathInput) {
        this.filepathInput = filepathInput;
    }

    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepathInput));
            String line = reader.readLine();

            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return result;
    }
}
