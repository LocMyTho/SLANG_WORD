import com.sun.java.accessibility.util.EventID;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        this.setTitle("Slang word");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        JPanel jPanel_menu = new JPanel();
        jPanel_menu.setLayout(new BorderLayout());

        JPanel jPanel_menu_center = new JPanel();
        jPanel_menu_center.setLayout(new GridLayout(5, 2));

        JButton btnSearchBySlangWord = new JButton("Search By SlangWord");
        JButton btnSearchByDefinition = new JButton("Search By Definition");
        JButton btnHistory = new JButton("History");
        JButton btnAddNewSlangWord = new JButton("Add New SlangWord");
        JButton btnEditSlangWord = new JButton("Edit SlangWord");
        JButton btnDeleteSlangWord = new JButton("Delete SlangWord");
        JButton btnResetSlangWordList = new JButton("Reset SlangWord List");
        JButton btnRandomSlangWord = new JButton("Random SlangWord");
        JButton btnQuestionSlangWord = new JButton("Question SlangWord");
        JButton btnQuestionDefinition = new JButton("Question Definition");

        jPanel_menu_center.add(btnSearchBySlangWord);
        jPanel_menu_center.add(btnSearchByDefinition);
        jPanel_menu_center.add(btnHistory);
        jPanel_menu_center.add(btnAddNewSlangWord);
        jPanel_menu_center.add(btnEditSlangWord);
        jPanel_menu_center.add(btnDeleteSlangWord);
        jPanel_menu_center.add(btnResetSlangWordList);
        jPanel_menu_center.add(btnRandomSlangWord);
        jPanel_menu_center.add(btnQuestionSlangWord);
        jPanel_menu_center.add(btnQuestionDefinition);

        jPanel_menu.add(jPanel_menu_center, BorderLayout.CENTER);

        Label label_slangword = new Label("SLANG WORD", Label.CENTER);
        label_slangword.setFont(new Font("Serif", Font.PLAIN, 50));


        jPanel_menu.add(label_slangword, BorderLayout.NORTH);

        this.setContentPane(jPanel_menu);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void SearchBySlangWord() {
        JPanel jPanel_SearchBySlangWord = new JPanel();
        jPanel_SearchBySlangWord.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_SearchBySlangWord = new JLabel("Search By Slang Word", JLabel.CENTER);
        jPanel_north.add(label_SearchBySlangWord);
        jPanel_north.setSize(300, 300);
        jPanel_SearchBySlangWord.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());

        JLabel label_slangword = new JLabel("Slang word");
        JTextField text_slangword = new JTextField();

        jPanel_center.add(label_slangword, BorderLayout.NORTH);
        jPanel_center.add(text_slangword, BorderLayout.NORTH);

        JTextArea x = new JTextArea();
        jPanel_center.add(x, BorderLayout.CENTER);

        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        JButton btnBack = new JButton("BACK");
        btnBack.setSize(100, 300);

        jPanel_south.add(btnBack);
        jPanel_SearchBySlangWord.add(jPanel_south, BorderLayout.SOUTH);

        jPanel_SearchBySlangWord.add(jPanel_center, BorderLayout.CENTER);

        this.setContentPane(jPanel_SearchBySlangWord);
    }

    public void SearchByDefinition() {
        JPanel jPanel_SearchByDefinition = new JPanel();
        jPanel_SearchByDefinition.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_SearchByDefinition = new JLabel("Search By Definition", JLabel.CENTER);
        jPanel_north.add(label_SearchByDefinition);
        jPanel_north.setSize(300, 300);
        jPanel_SearchByDefinition.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());

        JLabel label_definition = new JLabel("Definition");
        JTextField text_definition = new JTextField();

        jPanel_center.add(label_definition, BorderLayout.NORTH);
        jPanel_center.add(text_definition, BorderLayout.NORTH);

        JTextArea x = new JTextArea();
        jPanel_center.add(x, BorderLayout.CENTER);

        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        JButton btnBack = new JButton("BACK");
        btnBack.setSize(100, 300);

        jPanel_south.add(btnBack);
        jPanel_SearchByDefinition.add(jPanel_south, BorderLayout.SOUTH);

        jPanel_SearchByDefinition.add(jPanel_center, BorderLayout.CENTER);

        this.setContentPane(jPanel_SearchByDefinition);
    }

    public void History() {
        JPanel jPanel_history = new JPanel();
        jPanel_history.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_History = new JLabel("History", JLabel.CENTER);
        jPanel_north.add(label_History);
        jPanel_north.setSize(300, 300);
        jPanel_history.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        JButton btnBack = new JButton("BACK");
        btnBack.setSize(100, 300);

        jPanel_south.add(btnBack);
        jPanel_history.add(jPanel_south,BorderLayout.SOUTH);


        this.setContentPane(jPanel_history);

    }

    public void AddNewSlangWord(){
        JPanel jPanel_addNewSlangWord = new JPanel();
        jPanel_addNewSlangWord.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_addNewSlangWord = new JLabel("Add New Slang Word", JLabel.CENTER);
        jPanel_north.add(label_addNewSlangWord);
        jPanel_north.setSize(300, 300);
        jPanel_addNewSlangWord.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        JButton btnBack = new JButton("BACK");
        btnBack.setSize(100, 300);

        jPanel_south.add(btnBack);
        jPanel_addNewSlangWord.add(jPanel_south,BorderLayout.SOUTH);

        this.setContentPane(jPanel_addNewSlangWord);
    }


}
