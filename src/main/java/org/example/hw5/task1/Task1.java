package org.example.hw5.task1;

import java.util.HashMap;
import java.util.Map;
public class Task1 {
    public static void main(String[] args) {
        String str = "Россия идет вперед всей планеты. Планета — это не Россия.";

        System.out.println(isDuplicate(str));
    }

    public static boolean isDuplicate (String s) {
        System.out.println(s);
        Map<String, Integer> wordsCount = new HashMap<>();
        String[] split = s.toLowerCase().replaceAll("[\\p{Punct}]", "").split(" ");
        for (String word : split) {
            if (wordsCount.containsKey(word)) {
                return true;
            } else {
                wordsCount.put(word, 1);
            }
        }

        return false;
    }
}