package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    /**
     *  This program allows to read a file that contains a list of symptoms
     *  and write this list with their number of occurrences in an output file
     *  @author Marion
     */
    public static void main(String args[]) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();

        Map<String, Integer> counter = analyticsCounter.countSymptoms(symptoms);

        Map<String, Integer> resultOperation = analyticsCounter.sortSymptoms(counter);

        analyticsCounter.writeSymptoms(resultOperation);
    }
}
