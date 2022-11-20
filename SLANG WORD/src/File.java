import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class File {
    public HashMap<String, List<String>> readFile() throws IOException {
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        HashMap<String, List<String>> sw = new HashMap<String, List<String>>();


        try {
            fileInputStream = new FileInputStream("slang.txt");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line = reader.readLine();
            String key = "";
            List<String> value = new ArrayList<>();
            while (line != null) {
                key = line.substring(0, line.indexOf('`'));
                value = Arrays.asList(line.substring(line.indexOf('`') + 1, line.length()).split("\\| "));
                line = reader.readLine();

                if (line.indexOf('`') == -1) {
                    value.add(line);
                    line = reader.readLine();
                } else {
                    sw.put(key, value);
                }
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
