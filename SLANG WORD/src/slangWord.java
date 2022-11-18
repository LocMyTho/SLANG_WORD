import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class slangWord {
    private HashMap<String, String> sw = new HashMap<String, String>();
    private File file = new File();

    slangWord() throws IOException {
        sw = file.readFile();
    }
    //chức năng 1
    public String SearchBySlangWord(String key) {
        return sw.get(key);
    }
    //chức năng 2
    public String SearchByDefinition(String value) {
        Pattern pattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;
        boolean matchFound = true;
        for (String i : sw.keySet()) {
            if (sw.get(i).compareTo(value)==0) {
                return i;
            }
            matcher = pattern.matcher(sw.get(i));
            matchFound = matcher.find();
            if(matchFound) {
                System.out.println("Match found");
            }

            }
        return "0";
    }

    public String ShowAllSlangWordWithKeyword(String keyword){
        Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;
        boolean matchFound = true;
        for (String i : sw.keySet()) {
            matcher = pattern.matcher(sw.get(i));
            matchFound = matcher.find();
            if(matchFound) {
                System.out.println(sw.get(i));
            }
        }

        return "0";
    }
    //chức năng 3

    //chức năng 4
    public int AddNewSlangWord(String key,String value){
        if(this.SearchBySlangWord(key)!= null){
            sw.put(key,value);
            return 1;
        }
        else return 0;
    }
    //chức năng 5
    public int EditSlangWord(String key,String value){
        if(this.SearchBySlangWord(key)!= null) {
            sw.replace(key, value);
            return 1;
        }
        else return 0;
    }
    //chức năng 6
    public int DeleteSlangWord(String key){
        if(this.SearchBySlangWord(key)!= null) {
            sw.remove(key);
            return 1;
        }
        else return 0;
    }
    // chức năng 7
    public void ResetSlangWordList() throws IOException{
        sw = file.readFile();
    }
    //chức năng 8
    public String RandomSlangWord(){
        List<String> keyList = new ArrayList<String>(sw.keySet());
        int randomIndex = new Random().nextInt(keyList.size());
        String randomKey = keyList.get(randomIndex);
        return randomKey;
    }
    //chức năng 9


}
