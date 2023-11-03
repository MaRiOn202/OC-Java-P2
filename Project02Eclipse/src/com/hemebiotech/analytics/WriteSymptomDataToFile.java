package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;


/**
 *   Implements ISymptomWriter interface, writes a Map of String and their number
 *   of occurrences in a file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepathOutput;

    public WriteSymptomDataToFile(final String filepathOutput) {

        this.filepathOutput = filepathOutput;
    }

    /**
     * Method that creates a file output
     * @param symptoms Map<String, Integer>
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try(final FileWriter fileWriter = new FileWriter(filepathOutput) ) {

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                fileWriter.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
