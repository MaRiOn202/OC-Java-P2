package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> resultCountSymptoms = new HashMap<String, Integer>();

        for (String sympt : symptoms) {
            Integer count = resultCountSymptoms.get(sympt);
            resultCountSymptoms.put(sympt, count == null ? 1 : count + 1);
        }
        return resultCountSymptoms;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        TreeMap<String, Integer> resultSortSymptoms = new TreeMap<>(symptoms);

        return resultSortSymptoms;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}

