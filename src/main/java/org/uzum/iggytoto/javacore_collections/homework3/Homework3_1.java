package org.uzum.iggytoto.javacore_collections.homework3;

import java.util.HashMap;
import java.util.Map;

public class Homework3_1 {

    public Map<String,Integer> countWords(String text){
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split("[^a-zA-Zа-яА-Я]+");

        for (String word : words) {
            word = word.toLowerCase();
            if (!word.isEmpty()) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
        }

        return wordCount;
    }
}
