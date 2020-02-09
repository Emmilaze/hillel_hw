import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private String string;
    private String[] words;

    public StringUtils(String string) {
        this.string = string;
        words = string.replaceAll("[\\p{P}]", "").split(" ");
    }

    public HashMap<String, Integer> getNumberOfDuplicates() {
        HashMap<String, Integer> map = new HashMap();
        for (String word : words) {
            word = word.toLowerCase();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    public String changeCharacter(int k, char newChar) {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (word.length() >= k) {
                char[] array = word.toCharArray();
                for (int i = k - 1; i < array.length; i = i + k) {
                    array[i] = newChar;
                    word = String.valueOf(array);
                }
                builder.append(word).append(" ");
            } else {
                builder.append(word).append(" ");
            }
        }
        return builder.toString();
    }

    public HashSet<String> getFirstLast() {
//        HashMap<String, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            String first = String.valueOf(words[i].toCharArray()[0]);
            for (int j = 0; j < words.length - 1; j++) {
                char[] word = words[j].toCharArray();
                String last = String.valueOf(word[word.length - 1]);
                if (first.equalsIgnoreCase(last)) {
//                    map.put(words[i], words[j]);
                    set.add(words[i].toLowerCase());
                    set.add(words[j].toLowerCase());
                }
            }
        }
        return set;
    }

    public int getAmountOfPunctuationMarks() {
        Pattern pattern = Pattern.compile("[\\p{P}]");
        Matcher matcher = pattern.matcher(string);
        int amount = 0;
        while (matcher.find()) {
            amount++;
        }
        return amount;
    }
}
