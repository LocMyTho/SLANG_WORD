import java.io.*;
import java.util.HashMap;

public class File {
    public HashMap<String, String> readFile() throws IOException {
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        try {
            fileInputStream = new FileInputStream("slang.txt");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line = reader.readLine();
            ;
            while (line != null) {
                line = reader.readLine();
                System.out.println(line);
            }


            fileInputStream.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return capitalCities;
        }
    }
}
