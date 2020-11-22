import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class HandleTruthTest {
    public static Map<String, TreeMap<Integer, Set<String>>> getWordCountTestCases() {
        Map<String, TreeMap<Integer, Set<String>>> testcases = new HashMap<>();

        // Test 1
        String key = "son we live in a world that has walls and those walls have to be guarded by men with guns whos " +
                "gonna do it you you lieutenant weinberg i have a greater responsibility than you can possibly fathom" +
                " you weep for santiago and you curse the marines you have that luxury you have the luxury of not " +
                "knowing what i know that santiagos death while tragic probably saved lives and my existence while " +
                "grotesque and incomprehensible to you saves lives you dont want the truth because deep down in " +
                "places you dont talk about at parties you want me on that wall you need me on that wall we use " +
                "words like honor code loyalty we use these words as the backbone of a life spent defending " +
                "something you use them as a punchline i have neither the time nor the inclination to explain myself" +
                " to a man who rises and sleeps under the blanket of the very freedom that i provide and then " +
                "questions the manner in which i provide it i would rather you just said thank you and went on your" +
                " way otherwise i suggest you pick up a weapon and stand a post either way i dont give a damn what" +
                " you think you are entitled to";

        TreeMap<Integer, Set<String>> expected = new TreeMap<>();
        expected.put(18, new HashSet<>(Arrays.asList("you")));
        expected.put(9, new HashSet<>(Arrays.asList("the")));
        expected.put(8, new HashSet<>(Arrays.asList("a", "and", "i")));
        expected.put(6, new HashSet<>(Arrays.asList("that")));
        expected.put(5, new HashSet<>(Arrays.asList("have", "to")));
        expected.put(3, new HashSet<>(Arrays.asList("in", "use", "of", "dont", "we", "on")));
        expected.put(2, new HashSet<>(Arrays.asList("lives", "want", "words", "it", "while", "way", "as", "walls",
                "what", "provide", "me", "luxury", "wall")));
        expected.put(1, new HashSet<>(Arrays.asList("explain", "very", "guns", "saved", "lieutenant", "about", "your",
                "these", "saves", "would", "pick", "fathom", "grotesque", "incomprehensible", "because", "greater",
                "give", "sleeps", "went", "loyalty", "myself", "them", "then", "something", "at", "knowing", "santiago",
                "curse", "weinberg", "entitled", "whos", "be", "probably", "world", "freedom", "responsibility", "are",
                "by", "tragic", "backbone", "man", "stand", "inclination", "think", "gonna", "suggest", "places",
                "thank", "under", "punchline", "honor", "existence", "defending", "questions", "do", "manner", "down",
                "either", "son", "post", "than", "talk", "has", "up", "those", "possibly", "which", "otherwise", "need",
                "like", "my", "parties", "know", "santiagos", "rises", "who", "deep", "code", "death", "rather", "for",
                "weep", "life", "nor", "guarded", "can", "weapon", "not", "men", "said", "just", "live", "spent",
                "damn", "with", "truth", "marines", "neither", "time", "blanket")));
        testcases.put(key, expected);

        // Test 2
        key = "";
        expected = new TreeMap<>();
        expected.put(1, new HashSet<>(Arrays.asList("")));
        testcases.put(key, expected);

        // Test 3
        key = " ";
        expected = new TreeMap<>();
        testcases.put(key, expected);

        // Test 4
        key = "cat";
        expected = new TreeMap<>();
        expected.put(1, new HashSet<>(Arrays.asList("cat")));
        testcases.put(key, expected);

        // Test 5
        key = "cat cat cat";
        expected = new TreeMap<>();
        expected.put(3, new HashSet<>(Arrays.asList("cat")));
        testcases.put(key, expected);

        // Test 6
        key = "Cat Rat";
        expected = new TreeMap<>();
        expected.put(1, new HashSet<>(Arrays.asList("Rat", "Cat")));
        testcases.put(key, expected);

        // Test 7
        key = "cat CAT Cat CAT";
        expected = new TreeMap<>();
        expected.put(1, new HashSet<>(Arrays.asList("cat", "Cat")));
        expected.put(2, new HashSet<>(Arrays.asList("CAT")));
        testcases.put(key, expected);

        // Test 8
        key = "One Two Two Three Three Three";
        expected = new TreeMap<>();
        expected.put(1, new HashSet<>(Arrays.asList("One")));
        expected.put(2, new HashSet<>(Arrays.asList("Two")));
        expected.put(3, new HashSet<>(Arrays.asList("Three")));
        testcases.put(key, expected);

        return testcases;
    }

    @Test
    public void makeshiftTest() {
        Map<String, TreeMap<Integer, Set<String>>> testCases = getWordCountTestCases();

        for (Map.Entry<String, TreeMap<Integer, Set<String>>> entry : testCases.entrySet()) {
            Map<Integer, Set<String>> actual = HandleTruth.wordCount(entry.getKey());
            assertEquals(entry.getValue(), actual);
        }
    }
}