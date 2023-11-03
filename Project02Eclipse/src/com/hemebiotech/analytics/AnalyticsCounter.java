package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *   Class defines methods to read list of symptoms, sorts the symptoms alphabetically
 *   and writes these symptoms on file result.out
 */
public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     *  Public constructor
     * @param reader ISymptomReader
     * @param writer ISymptomWriter
     */
    public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Return list of symptoms
     * @return List<String>
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Counts the number of occurrences of symptoms
     * @param symptoms List<String>
     * @return Map<String, Integer>
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> resultCountSymptoms = new HashMap<String, Integer>();

        for (String sympt : symptoms) {
            Integer count = resultCountSymptoms.get(sympt);
            resultCountSymptoms.put(sympt, count == null ? 1 : count + 1);
        }
        return resultCountSymptoms;
    }

    /**
     * Allows sorting symptoms in alphabetical order
     * @param symptoms Map<String, Integer>
     * @return Map<String, Integer>
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        TreeMap<String, Integer> resultSortSymptoms = new TreeMap<>(symptoms);

        return resultSortSymptoms;
    }

    /**
     * Writes symptoms
     * @param symptoms Map<String, Integer>
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}

