import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {

        System.out.println(getChanges(args[0]));
    }

    private static String getChanges(String str) {

        if (str.length() % 2 == 1) {
            return String.valueOf("-1");
        }

        String first_str = str.substring(0, (str.length()/2));
        String second_str = str.substring((str.length()/2));

        // add to hashmap - character and number of occurrence
        Map<Character, Integer> firstMap = new HashMap<Character, Integer>();
        Map<Character, Integer> secondMap = new HashMap<Character, Integer>();

        for (char i : first_str.toCharArray()) {
            firstMap.put(i, firstMap.getOrDefault(i, 0) + 1);
        }
        for (char i : second_str.toCharArray()) {
            secondMap.put(i, secondMap.getOrDefault(i, 0) + 1);
        }

        int count = 0;

        // iterate through first array and check if the characters are in the second array, missing characters are count
        for (Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
            char key_first = entry.getKey();
            int value_first = entry.getValue();
            if (secondMap.containsKey(key_first)) {
                int value_second = secondMap.get(key_first);
                if (value_second < value_first) {
                    count = count + (value_first - value_second);
                }
            } else {
                count = count + value_first;
            }
        }

        return String.valueOf(count);
    }
}
