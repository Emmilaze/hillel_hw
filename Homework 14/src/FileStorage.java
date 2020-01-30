import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStorage {

    public String readFile(String filePath) {
        String str = null;
        try {
            str = new String(Files.readAllBytes(Paths.get(String.valueOf(filePath))));
        } catch (IOException e) {
            e.printStackTrace();
        }
         return str;
    }
}
