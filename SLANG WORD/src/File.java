import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class File {
    public HashMap<String, String> readFile() throws IOException {
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        HashMap<String, String> sw = new HashMap<String, String>();

        try {
            fileInputStream = new FileInputStream("slang.txt");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line = reader.readLine();
            String key = "";
            String value = "";
            while (line != null) {
                line = reader.readLine();
                key = line.substring(0, line.indexOf('`'));
                value = line.substring(line.indexOf('`') + 1, line.length());
                sw.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            reader.close();
            return sw;
        }
    }
}
