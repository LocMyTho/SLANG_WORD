import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class slangWord {
    private HashMap<String, List<String>> sw = new HashMap<String, List<String>>();
    private File file = new File();

    slangWord() throws IOException {
        sw = file.readFile();
    }

    //chức năng 1
    public List<String> SearchBySlangWord(String key) {
        return sw.get(key);
    }

    //chức năng 2
    public List<String> SearchByDefinition(String value) {
        Pattern pattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;
        boolean matchFound = true;
        List<String> result = new ArrayList<>();
        for (String i : sw.keySet()) {
            for (String j : sw.get(i)) {
                matcher = pattern.matcher(j);
                matchFound = matcher.find();
                if (matchFound) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public List<String> ShowAllSlangWordWithKeyword(String keyword) {
        Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;
        boolean matchFound = true;
        List<String> result = new ArrayList<>();
        for (String i : sw.keySet()) {
            for (String j : sw.get(i)) {
                matcher = pattern.matcher(j);
                matchFound = matcher.find();
                if (matchFound) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }
    //chức năng 3

    //chức năng 4
    public int AddNewSlangWord(String key, String value) {
        if (this.SearchBySlangWord(key) != null) {
            List<String> newValue = Arrays.asList(value.substring(value.indexOf('`') + 1,
                    value.length()).split("\\| "));
            sw.put(key, newValue);
            return 1;
        } else return 0;
    }

    //chức năng 5
    public int EditSlangWord(String key, String value) {
        if (this.SearchBySlangWord(key) != null) {
            List<String> newValue = Arrays.asList(value.substring(value.indexOf('`') + 1,
                    value.length()).split("\\| "));
            sw.replace(key, newValue);
            return 1;
        } else return 0;
    }

    //chức năng 6
    public int DeleteSlangWord(String key) {
        if (this.SearchBySlangWord(key) != null) {
            sw.remove(key);
            return 1;
        } else return 0;
    }

    // chức năng 7
    public void ResetSlangWordList() throws IOException {
        sw = file.readFile();
    }

    //chức năng 8
    public String RandomSlangWord() {
        List<String> keyList = new ArrayList<String>(sw.keySet());
        int randomIndex = new Random().nextInt(keyList.size());
        String randomKey = keyList.get(randomIndex);
        return randomKey;
    }

    //  chức năng 9
    public List<String> RandomDefinition() {
        List<List<String>> valueList = new ArrayList<List<String>>(sw.values());
        int randomIndex = new Random().nextInt(valueList.size());
        List<String> randomValue = valueList.get(randomIndex);
        return randomValue;
    }


}
