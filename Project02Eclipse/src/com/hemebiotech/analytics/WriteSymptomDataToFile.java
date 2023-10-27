package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepathoutput;

    public WriteSymptomDataToFile(String filepathoutput) {
        this.filepathoutput = filepathoutput;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try(final FileWriter fileWriter = new FileWriter("result.out") ) {

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                fileWriter.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}