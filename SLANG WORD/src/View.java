import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;


public class View extends JFrame {

    private ActionListener ac = new Controller(this);
    public JButton btnSearchBySlangWord;
    public JButton btnSearchByDefinition;
    public JButton btnHistory;
    public JButton btnAddNewSlangWord;
    public JButton btnEditSlangWord;
    public JButton btnDeleteSlangWord;
    public JButton btnResetSlangWordList;
    public JButton btnRandomSlangWord;
    public JButton btnQuestionSlangWord;
    public JButton btnQuestionDefinition;
    public JTextField text_slangword;
    public JButton btn_searchBySlangword;
    public JButton btn_searchByDefinition;
    public DefaultTableModel model;
    public JTable table;
    public JButton btnBack;
    public JTextField text_definition;
    public JButton btnAdd;
    public JButton btnEdit;
    public JButton btnDelete;
    public JButton btnRandom;


    public View() throws IOException {
        this.setTitle("Slang word");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        this.Menu();

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void Menu() {

        JPanel jPanel_menu = new JPanel();
        jPanel_menu.setLayout(new BorderLayout());

        JPanel jPanel_menu_center = new JPanel();
        jPanel_menu_center.setLayout(new GridLayout(5, 2, 30, 30));

        btnSearchBySlangWord = new JButton("Search By SlangWord");
        btnSearchBySlangWord.addActionListener(ac);
        btnSearchByDefinition = new JButton("Search By Definition");
        btnSearchByDefinition.addActionListener(ac);
        btnHistory = new JButton("History");
        btnHistory.addActionListener(ac);
        btnAddNewSlangWord = new JButton("Add New SlangWord");
        btnAddNewSlangWord.addActionListener(ac);
        btnEditSlangWord = new JButton("Edit SlangWord");
        btnEditSlangWord.addActionListener(ac);
        btnDeleteSlangWord = new JButton("Delete SlangWord");
        btnDeleteSlangWord.addActionListener(ac);
        btnResetSlangWordList = new JButton("Reset SlangWord List");
        btnResetSlangWordList.addActionListener(ac);
        btnRandomSlangWord = new JButton("Random SlangWord");
        btnRandomSlangWord.addActionListener(ac);
        btnQuestionSlangWord = new JButton("Question SlangWord");
        btnQuestionDefinition = new JButton("Question Definition");

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
        jPanel_menu.add(new JPanel(), BorderLayout.WEST);
        jPanel_menu.add(new JPanel(), BorderLayout.EAST);


        Label label_slangword = new Label("SLANG WORD", Label.CENTER);
        label_slangword.setFont(new Font("Serif", Font.PLAIN, 50));

        jPanel_menu.add(label_slangword, BorderLayout.NORTH);

        this.setContentPane(jPanel_menu);
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
        text_slangword = new JTextField(50);
        btn_searchBySlangword = new JButton("Search");
        btn_searchBySlangword.addActionListener(ac);

        jPanel_center_north.add(label_slangword);
        jPanel_center_north.add(text_slangword);
        jPanel_center_north.add(btn_searchBySlangword);

        jPanel_center.add(jPanel_center_north, BorderLayout.NORTH);

        String[][] data = null;
        String column[] = {"Slang word", "Definition"};

        model = new DefaultTableModel(data, column);
        table = new JTable(model);

        jPanel_center.add(new JScrollPane(table), BorderLayout.CENTER);


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);

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
        text_definition = new JTextField(50);
        btn_searchByDefinition = new JButton("Search");
        btn_searchByDefinition.addActionListener(ac);

        jPanel_center_north.add(label_definition);
        jPanel_center_north.add(text_definition);
        jPanel_center_north.add(btn_searchByDefinition);

        jPanel_center.add(jPanel_center_north, BorderLayout.NORTH);

        String[][] data = null;
        String column[] = {"Slang word", "Definition"};

        model = new DefaultTableModel(data, column);
        table = new JTable(model);

        jPanel_center.add(new JScrollPane(table), BorderLayout.CENTER);


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());
        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);

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

        model = new DefaultTableModel(data, column);
        table = new JTable(model);

        jPanel_center.add(new JScrollPane(table), BorderLayout.CENTER);
        jPanel_history.add(jPanel_center, BorderLayout.CENTER);

        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);

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
        jPanel_center.setLayout(new GridLayout(3, 1));

        JPanel jPanel_center_sw = new JPanel();
        jPanel_center_sw.setLayout(new FlowLayout());
        JLabel label_sw = new JLabel("Slangword");
        text_slangword = new JTextField(50);
        jPanel_center_sw.add(label_sw);
        jPanel_center_sw.add(text_slangword);

        JPanel jPanel_center_definition = new JPanel();
        jPanel_center_definition.setLayout(new FlowLayout());
        JLabel label_definition = new JLabel("Definition");
        text_definition = new JTextField(50);
        jPanel_center_definition.add(label_definition);
        jPanel_center_definition.add(text_definition);

        JPanel jPanel_center_btn = new JPanel();
        jPanel_center_btn.setLayout(new FlowLayout());
        btnAdd = new JButton("Add");
        jPanel_center_btn.add(btnAdd);
        btnAdd.addActionListener(ac);


        jPanel_center.add(jPanel_center_sw);
        jPanel_center.add(jPanel_center_definition);
        jPanel_center.add(jPanel_center_btn);
        jPanel_addNewSlangWord.add(jPanel_center, BorderLayout.CENTER);


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);


        jPanel_south.add(btnBack);
        jPanel_addNewSlangWord.add(jPanel_south, BorderLayout.SOUTH);

        this.setContentPane(jPanel_addNewSlangWord);
        this.setVisible(true);
    }

    public void EditSlangWord() {
        JPanel jPanel_editSlangWord = new JPanel();
        jPanel_editSlangWord.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_editSlangWord = new JLabel("Edit New Slang Word", JLabel.CENTER);
        jPanel_north.add(label_editSlangWord);

        jPanel_editSlangWord.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new GridLayout(3, 1));

        JPanel jPanel_center_sw = new JPanel();
        jPanel_center_sw.setLayout(new FlowLayout());
        JLabel label_sw = new JLabel("Slangword");
        text_slangword = new JTextField(50);
        jPanel_center_sw.add(label_sw);
        jPanel_center_sw.add(text_slangword);

        JPanel jPanel_center_definition = new JPanel();
        jPanel_center_definition.setLayout(new FlowLayout());
        JLabel label_definition = new JLabel("Definition");
        text_definition = new JTextField(50);
        jPanel_center_definition.add(label_definition);
        jPanel_center_definition.add(text_definition);

        JPanel jPanel_center_btn = new JPanel();
        jPanel_center_btn.setLayout(new FlowLayout());
        btnEdit = new JButton("Edit");
        jPanel_center_btn.add(btnEdit);

        jPanel_center.add(jPanel_center_sw);
        jPanel_center.add(jPanel_center_definition);
        jPanel_center.add(jPanel_center_btn);
        jPanel_editSlangWord.add(jPanel_center, BorderLayout.CENTER);


        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);


        jPanel_south.add(btnBack);
        jPanel_editSlangWord.add(jPanel_south, BorderLayout.SOUTH);

        this.setContentPane(jPanel_editSlangWord);
        this.setVisible(true);
    }

    public void DeleteSlangWord() {
        JPanel jPanel_deleteSlangWord = new JPanel();
        jPanel_deleteSlangWord.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_deleteSlangWord = new JLabel("Delete Slang Word", JLabel.CENTER);
        jPanel_north.add(label_deleteSlangWord);

        jPanel_deleteSlangWord.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new GridLayout(3, 1));

        JPanel jPanel_center_sw = new JPanel();
        jPanel_center_sw.setLayout(new FlowLayout());
        JLabel label_sw = new JLabel("Slangword");
        text_slangword = new JTextField(50);
        jPanel_center_sw.add(label_sw);
        jPanel_center_sw.add(text_slangword);

        JPanel jPanel_center_btn = new JPanel();
        jPanel_center_btn.setLayout(new FlowLayout());
        btnDelete = new JButton("Delete");
        jPanel_center_btn.add(btnDelete);

        jPanel_center.add(jPanel_center_sw);
        jPanel_center.add(jPanel_center_btn);
        jPanel_deleteSlangWord.add(jPanel_center, BorderLayout.CENTER);

        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);

        jPanel_south.add(btnBack);
        jPanel_deleteSlangWord.add(jPanel_south, BorderLayout.SOUTH);

        this.setContentPane(jPanel_deleteSlangWord);
        this.setVisible(true);
    }

    public void RandomSlangWord() {
        JPanel jPanel_randomSlangWord = new JPanel();
        jPanel_randomSlangWord.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        JLabel label_randomSlangWord = new JLabel("Random Slang Word", JLabel.CENTER);
        jPanel_north.add(label_randomSlangWord);

        jPanel_randomSlangWord.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new GridLayout(3, 1));

        JPanel jPanel_center_sw = new JPanel();
        jPanel_center_sw.setLayout(new FlowLayout());
        JLabel label_sw = new JLabel("Slangword");
        text_slangword = new JTextField(50);
        jPanel_center_sw.add(label_sw);
        jPanel_center_sw.add(text_slangword);

        JPanel jPanel_center_definition = new JPanel();
        jPanel_center_definition.setLayout(new FlowLayout());
        JLabel label_definition = new JLabel("Definition");
        text_definition = new JTextField(50);
        jPanel_center_definition.add(label_definition);
        jPanel_center_definition.add(text_definition);

        JPanel jPanel_center_btn = new JPanel();
        jPanel_center_btn.setLayout(new FlowLayout());
        btnRandom = new JButton("Random");
        jPanel_center_btn.add(btnRandom);

        jPanel_center.add(jPanel_center_sw);
        jPanel_center.add(jPanel_center_definition);
        jPanel_center.add(jPanel_center_btn);
        jPanel_randomSlangWord.add(jPanel_center, BorderLayout.CENTER);

        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);

        jPanel_south.add(btnBack);
        jPanel_randomSlangWord.add(jPanel_south, BorderLayout.SOUTH);

        this.setContentPane(jPanel_randomSlangWord);
        this.setVisible(true);
    }

}

