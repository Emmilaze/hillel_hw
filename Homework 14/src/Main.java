import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        StringParser stringParser = new StringParser();
        String[] str = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            str = stringParser.parse(fileStorage.readFile(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry entry : stringParser.getPairs(str).entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }
}
