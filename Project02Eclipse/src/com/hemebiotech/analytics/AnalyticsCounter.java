package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class AnalyticsCounter {
    public static int headacheCount = 0;
    public static int rashCount = 0;
    public static int pupilCount = 0;


    public static void main(String args[]) throws Exception {

        try {

            FileReader fileReader = new FileReader("symptoms.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();


            int i = 0;
            int headachesCount = 0;
            while (line != null) {
                i++;
                System.out.println("symptom from file: " + line);
                if (line.equals("headache")) {
                    headachesCount++;
                    System.out.println("number of headaches: " + headachesCount);
                } else if (line.equals("rush")) {
                    rashCount++;
                } else if (line.contains("pupils")) {
                    pupilCount++;
                }

                line = reader.readLine();
            }


            FileWriter writer = new FileWriter("result.out");
            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dialated pupils: " + pupilCount + "\n");
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
