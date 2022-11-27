import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class File {
    public HashMap<String, List<String>> readFile(String filename) throws IOException {
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        HashMap<String, List<String>> sw = new HashMap<String, List<String>>();


        try {
            fileInputStream = new FileInputStream(filename);
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line = "";
            String key = "";
            List<String> value = new ArrayList<>();
            while (line != null) {
                line = reader.readLine();
                if (line.indexOf('`') == -1) {
                    line = reader.readLine();
                }
                key = line.substring(0, line.indexOf('`'));
                value = Arrays.asList(line.substring(line.indexOf('`') + 1, line.length()).split("\\| "));
                sw.put(key, value);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            fileInputStream.close();
            return sw;
        }
    }

    public void WriteFile(HashMap<String, List<String>> sw, String filename) throws IOException {
        FileOutputStream fileOutputStream = null;
        BufferedWriter writer = null;

        try {
            fileOutputStream = new FileOutputStream(filename);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            if(sw!=null) {
                for (String slangword : sw.keySet()) {
                    String definition = String.join("| ", sw.get(slangword));
                    String line = slangword + "`" + definition + "\n";
                    writer.write(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            fileOutputStream.close();
        }
    }

    public void WriteFileAppend(String slangword, List<String> listDefinition, String filename) throws IOException {
        FileOutputStream fileOutputStream = null;
        BufferedWriter writer = null;

        try {
            fileOutputStream = new FileOutputStream(filename, true);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

            String definition = String.join("| ", listDefinition);
            String line = slangword + "`" + definition + "\n";
            writer.write(line);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            fileOutputStream.close();
        }
    }

}
