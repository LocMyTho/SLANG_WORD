import java.io.IOException;
import java.util.*;

public class slangWord {
    public HashMap<String, String> sw = new HashMap<String, String>();
    public File file = new File();

    slangWord() throws IOException {
        sw = file.readFile("mySlang.txt");
    }

    //chức năng 1
    public String SearchBySlangWord(String key) {
        return sw.get(key);
    }

    //chức năng 2
    public HashMap<String, String> SearchByDefinition(String value) {
        HashMap<String, String> result = new HashMap<String, String>();
        for (String i : sw.keySet()) {
            if (sw.get(i).matches("(.*)" + value + "(.*)")) {
                result.put(i, sw.get(i));
            }
        }
        return result;
    }

    //chức năng 3

    public HashMap<String, String> History() throws IOException {
        return file.readFile("history.txt");
    }

    public void SaveHistory(HashMap<String, String> history) throws IOException {
        file.WriteFile(history, "history.txt");
    }

    public void ResetHistory() throws IOException {
        file.WriteFile(null, "history.txt");
    }


    //chức năng 4
    public void AddNewSlangWord(String key, String value, String type) throws IOException {

        if (type == "Confirm") {
            sw.put(key, value);
        } else if (type == "duplicate") {
            String definition = SearchBySlangWord(key);
            definition += "| " + value;
            sw.replace(key, definition);
        } else if (type == "overwrite") {
            sw.replace(key, value);
        }
        file.WriteFile(sw, "mySlang.txt");
    }

    //chức năng 5
    public void EditSlangWord(String key, String value) throws IOException {
        if (this.SearchBySlangWord(key) != null) {
            sw.replace(key, value);
            file.WriteFile(sw, "mySlang.txt");
        }
    }

    //chức năng 6
    public int DeleteSlangWord(String key) throws IOException {
        if (this.SearchBySlangWord(key) != null) {
            sw.remove(key);
            file.WriteFile(sw, "mySlang.txt");
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
    public String RandomDefinition() {
        List<String> valueList = new ArrayList<>(sw.values());
        int randomIndex = new Random().nextInt(valueList.size());
        String randomValue = valueList.get(randomIndex);
        return randomValue;
    }

    public List<String> QuestionSlangword() {
        List<String> QA = new ArrayList<String>();
        String slangword = RandomSlangWord();
        String definition = SearchBySlangWord(slangword);

        QA.add(slangword);
        QA.add(definition);
        int check;
        while (QA.size() < 5) {
            definition = RandomDefinition();
            check = 0;
            for (String i : QA) {
                if (i.compareTo(definition) == 0) {
                    check++;
                }
            }
            if (check == 0) QA.add(definition);
        }
        return QA;
    }

    // chức năng 10
    public List<String> QuestionDefinition() {
        List<String> QA = new ArrayList<String>();
        String slangword = RandomSlangWord();
        String definition = SearchBySlangWord(slangword);

        QA.add(definition);
        QA.add(slangword);
        int check;
        while (QA.size() < 5) {
            slangword = RandomSlangWord();
            check = 0;
            for (String i : QA) {
                if (i.compareTo(slangword) == 0) {
                    check++;
                }
            }
            if (check == 0) QA.add(slangword);
        }
        return QA;
    }

}
