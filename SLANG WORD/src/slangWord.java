import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class slangWord {
    public HashMap<String, List<String>> sw = new HashMap<String, List<String>>();
    private File file = new File();

    slangWord() throws IOException {
        sw = file.readFile("mySlang.txt");
    }

    //chức năng 1
    public List<String> SearchBySlangWord(String key) {
        return sw.get(key);
    }

    //chức năng 2
    public HashMap<String, List<String>> SearchByDefinition(String value) {
        Pattern pattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;
        boolean matchFound = true;
        HashMap<String, List<String>> result = new HashMap<String, List<String>>();
        for (String i : sw.keySet()) {
            for (String j : sw.get(i)) {
                matcher = pattern.matcher(j);
                matchFound = matcher.find();
                if (matchFound) {
                    result.put(i,sw.get(i));
                }
            }

        }
        return result;
    }

    //chức năng 3

    public HashMap<String, List<String>> History() throws IOException {
        return file.readFile("history.txt");
    }

    public void SaveHistory(String slangword,List<String> ListDefinition) throws IOException {
        file.WriteFileAppend(slangword,ListDefinition,"history.txt");
    }

    public void ResetHistory() throws IOException {
        file.WriteFile(null,"history.txt");
    }


    //chức năng 4
    public void AddNewSlangWord(String key, String value,String type) throws IOException {
        List<String> newValue = Arrays.asList(value.split("\\| "));
        if(type == "Confirm"){
            sw.put(key, newValue);
        } else if (type == "duplicate") {
            List<String> definition = SearchBySlangWord(key);
            String oldDefiniton = String.join(" | ", definition);
            oldDefiniton += " | " + value;
            definition = Arrays.asList(oldDefiniton.split("\\| "));
            sw.replace(key,definition);
        } else if (type == "overwrite") {
            sw.replace(key, newValue);
        }
        file.WriteFile(sw,"mySlang.txt");
    }

    //chức năng 5
    public void EditSlangWord(String key, String value) throws IOException {
        if (this.SearchBySlangWord(key) != null) {
            List<String> newValue = Arrays.asList(value.substring(value.indexOf('`') + 1,
                    value.length()).split("\\| "));
            sw.replace(key, newValue);
            file.WriteFile(sw,"mySlang.txt");
        }
    }

    //chức năng 6
    public int DeleteSlangWord(String key) throws IOException {
        if (this.SearchBySlangWord(key) != null) {
            sw.remove(key);
            file.WriteFile(sw,"mySlang.txt");
            return 1;
        } else return 0;
    }

    // chức năng 7
    public void ResetSlangWordList() throws IOException {
        sw = file.readFile("slang.txt");
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
