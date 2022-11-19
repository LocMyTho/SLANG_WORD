import javax.swing.*;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
//        JFrame jf = new JFrame();
//        jf.setTitle("Slang word");
//        jf.setSize(800,600);
//        jf.setLocationRelativeTo(null);
//        //jf.setLocation(300,100);
//
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        jf.setVisible(true);

        slangWord sw = new slangWord();
//        List <String> x = sw.SearchBySlangWord(">.<");
//        for (String i : x){
//            System.out.println(i);
//        }
//        List <String> y = sw.SearchByDefinition("angry");
//        for (String i : y){
//            System.out.println(i);
//        }

        sw.ShowAllSlangWordWithKeyword("love");
    }
}