import com.sun.java.accessibility.util.EventID;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class View extends JFrame implements ActionListener {


    public View() {
        this.setTitle("Slang word");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);


        JPanel jPanel_menu = new JPanel();
        jPanel_menu.setLayout(new BorderLayout());

        JPanel jPanel_menu_center = new JPanel();
        jPanel_menu_center.setLayout(new GridLayout(5, 2, 50, 50));

        JButton btnSearchBySlangWord = new JButton("Search By SlangWord");
        btnSearchBySlangWord.addActionListener(this);
        JButton btnSearchByDefinition = new JButton("Search By Definition");
        btnSearchByDefinition.addActionListener(this);
        JButton btnHistory = new JButton("History");
        btnHistory.addActionListener(this);
        JButton btnAddNewSlangWord = new JButton("Add New SlangWord");
        btnAddNewSlangWord.addActionListener(this);
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
        jPanel_SearchBySlangWord.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());

        JPanel jPanel_center_north = new JPanel();
        jPanel_center_north.setLayout(new FlowLayout());

        JLabel label_slangword = new JLabel("Slang word");
        JTextField text_slangword = new JTextField(50);
        JButton btn_searchBySlangword = new JButton("Search");

        jPanel_center_north.add(label_slangword);
        jPanel_center_north.add(text_slangword);
        jPanel_center_north.add(btn_searchBySlangword);

        jPanel_center.add(jPanel_center_north, BorderLayout.NORTH);

        String[][] data = null;
        String column[] = {"Slang word", "Definition"};

        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);

        jPanel_center.add(new JScrollPane(table), BorderLayout.CENTER);


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        JButton btnBack = new JButton("BACK");

        jPanel_south.add(btnBack);
        jPanel_SearchBySlangWord.add(jPanel_south, BorderLayout.SOUTH);

        jPanel_SearchBySlangWord.add(jPanel_center, BorderLayout.CENTER);

        this.setContentPane(jPanel_SearchBySlangWord);
        this.setVisible(true);
    }

    public void SearchByDefinition() {
        JPanel jPanel_SearchByDefinition = new JPanel();
        jPanel_SearchByDefinition.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_SearchByDefinition = new JLabel("Search By Definition", JLabel.CENTER);
        jPanel_north.add(label_SearchByDefinition);
        jPanel_SearchByDefinition.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());

        JPanel jPanel_center_north = new JPanel();
        jPanel_center_north.setLayout(new FlowLayout());

        JLabel label_definition = new JLabel("Definition");
        JTextField text_definition = new JTextField(50);

        jPanel_center_north.add(label_definition);
        jPanel_center_north.add(text_definition);

        jPanel_center.add(jPanel_center_north, BorderLayout.NORTH);

        String[][] data = null;
        String column[] = {"Slang word", "Definition"};

        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);

        jPanel_center.add(new JScrollPane(table), BorderLayout.CENTER);


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        JButton btnBack = new JButton("BACK");

        jPanel_south.add(btnBack);
        jPanel_SearchByDefinition.add(jPanel_south, BorderLayout.SOUTH);
        jPanel_SearchByDefinition.add(jPanel_center, BorderLayout.CENTER);

        this.setContentPane(jPanel_SearchByDefinition);
        this.setVisible(true);
    }

    public void History() {
        JPanel jPanel_history = new JPanel();
        jPanel_history.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_History = new JLabel("History", JLabel.CENTER);
        jPanel_north.add(label_History);
        jPanel_history.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());

        String[][] data = null;
        String column[] = {"Slang word", "Definition"};

        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);

        jPanel_center.add(new JScrollPane(table),BorderLayout.CENTER);
        jPanel_history.add(jPanel_center,BorderLayout.CENTER);


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        JButton btnBack = new JButton("BACK");

        jPanel_south.add(btnBack);
        jPanel_history.add(jPanel_south, BorderLayout.SOUTH);


        this.setContentPane(jPanel_history);
        this.setVisible(true);

    }

    public void AddNewSlangWord() {
        JPanel jPanel_addNewSlangWord = new JPanel();
        jPanel_addNewSlangWord.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_addNewSlangWord = new JLabel("Add New Slang Word", JLabel.CENTER);
        jPanel_north.add(label_addNewSlangWord);

        jPanel_addNewSlangWord.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        JButton btnBack = new JButton("BACK");


        jPanel_south.add(btnBack);
        jPanel_addNewSlangWord.add(jPanel_south, BorderLayout.SOUTH);

        this.setContentPane(jPanel_addNewSlangWord);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("Search By SlangWord") == 0) {
            this.SearchBySlangWord();
        } else if (e.getActionCommand().compareTo("Search By Definition") == 0) {
            this.SearchByDefinition();
        } else if (e.getActionCommand().compareTo("History") == 0) {
            this.History();
        }else if (e.getActionCommand().compareTo("Add New SlangWord") == 0) {
            this.AddNewSlangWord();
        }

    }
}
