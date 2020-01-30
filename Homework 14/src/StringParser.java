import java.util.HashMap;

public class StringParser {
    HashMap<String, Integer> map = new HashMap<>();

    public String[] parse(String file) {
        file = file.replaceAll("[\\p{P}]", "");
        return file.split(" ");
    }

    public HashMap<String, Integer> getPairs(String[] words) {
        for (String str : words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        return map;
    }
}
