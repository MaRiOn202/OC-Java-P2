package com.hemebiotech.analytics;

import java.util.Map;

/**
 *   Interface that allows to write symptoms and their number of occurrences in a Map
 */
public interface ISymptomWriter {

     /**
      * Method void
      * @param symptoms Map<String, Integer>
      */
     void writeSymptoms(Map<String, Integer> symptoms);

}
