import javax.swing.*;
import java.io.IOException;


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
        System.out.println(sw.SearchBySlangWord("#1"));
        System.out.println(sw.SearchByDefinition("Number one"));
        sw.ShowAllSlangWordWithKeyword("Love");

    }
}