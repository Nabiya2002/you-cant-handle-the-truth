import java.util.*;

public class HandleTruth {
    public static Map<Integer, Set<String>> wordCount(String msg) {
        String[] words = msg.split(" ");

        // use map to count the occurrences of each word
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
                continue;
            }
            wordMap.put(word, 1);
        }

        return getSortedMap(wordMap);
    }

    // sort the map based on number of occurrences
    private static Map<Integer, Set<String>> getSortedMap(HashMap<String, Integer> wordMap) {
        Map<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int key = entry.getValue();
            Set<String> values = sortedMap.containsKey(key) ?
                    sortedMap.get(key) : new HashSet<>();
            values.add(entry.getKey());
            sortedMap.put(entry.getValue(), values);
        }

        return sortedMap;
    }
}