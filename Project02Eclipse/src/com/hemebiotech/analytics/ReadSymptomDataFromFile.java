package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  Implements the interface ISymptomReader to read the list of symptoms
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepathInput;

    /**
     * Public constructor
     * @param filepathInput String
     */
    public ReadSymptomDataFromFile(String filepathInput) {
        this.filepathInput = filepathInput;
    }

    /**
     * Gets a list of symptoms
     * @return List<String>
     */
    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<>();

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
