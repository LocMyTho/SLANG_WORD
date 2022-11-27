import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;


public class View extends JFrame {


    enum Screen {
        searchBySlangword,
        searchByDefinition,
        history,
        add,
        edit,
        delete,
        random,
        questionSW,
        questionDE
    }

    public Screen screen = Screen.searchBySlangword;
    private final ActionListener ac = new Controller(this);
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
    public JLabel label_title;
    public JTextField text_slangword;
    public JTextField text_definition;
    public JButton btn_search;
    public JButton btn_input;
    public JLabel label_slangword;
    public JLabel label_definition;
    public DefaultTableModel model;
    public JTable table;
    public JButton btnBack;
    public JButton btn_a;
    public JButton btn_b;
    public JButton btn_c;
    public JButton btn_d;


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
        btnQuestionSlangWord.addActionListener(ac);
        btnQuestionDefinition = new JButton("Question Definition");
        btnQuestionDefinition.addActionListener(ac);

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

    public void view() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        JPanel jPanel_north = new JPanel();

        label_title = new JLabel("", JLabel.CENTER);
        label_title.setFont(new Font("Arial", Font.PLAIN, 30));
        jPanel_north.add(label_title);
        jPanel.add(jPanel_north, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());

        JPanel jPanel_center_north = new JPanel();
        jPanel_center_north.setLayout(new GridLayout(2, 1));

        JPanel jPanel_slangword = new JPanel();
        jPanel_slangword.setLayout(new FlowLayout());

        label_slangword = new JLabel("");
        text_slangword = new JTextField(50);
        btn_search = new JButton("");
        btn_search.addActionListener(ac);

        jPanel_slangword.add(label_slangword);
        jPanel_slangword.add(text_slangword);
        jPanel_slangword.add(btn_search);

        JPanel jPanel_definition = new JPanel();
        jPanel_definition.setLayout(new FlowLayout());

        label_definition = new JLabel("");
        text_definition = new JTextField(50);
        btn_input = new JButton("");
        btn_input.addActionListener(ac);

        jPanel_definition.add(label_definition);
        jPanel_definition.add(text_definition);
        jPanel_definition.add(btn_input);

        jPanel_center_north.add(jPanel_slangword);
        jPanel_center_north.add(jPanel_definition);

        jPanel_center.add(jPanel_center_north, BorderLayout.NORTH);

        String[] column = {"Slang word", "Definition"};

        model = new DefaultTableModel(null, column);
        table = new JTable(model);
        table.setEnabled(false);

        jPanel_center.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);

        jPanel_south.add(btnBack);
        jPanel.add(jPanel_south, BorderLayout.SOUTH);

        jPanel.add(jPanel_center, BorderLayout.CENTER);

        switch (screen) {
            case searchBySlangword -> {
                label_title.setText("Search By Slang Word");
                label_slangword.setText("SlangWord");
                btn_search.setText("Search");
                label_definition.setVisible(false);
                text_definition.setVisible(false);
                btn_input.setVisible(false);
            }
            case searchByDefinition -> {
                label_title.setText("Search By Definition");
                label_slangword.setText("Definition");
                btn_search.setText("Search");
                label_definition.setVisible(false);
                text_definition.setVisible(false);
                btn_input.setVisible(false);
            }
            case history -> {
                label_title.setText("History");
                label_slangword.setVisible(false);
                text_slangword.setVisible(false);
                btn_search.setVisible(false);
                label_definition.setVisible(false);
                text_definition.setVisible(false);
                btn_input.setText("reset");
            }
            case add -> {
                label_title.setText("Add New Slang Word");
                label_slangword.setText("SlangWord");
                btn_search.setText("Search");
                label_definition.setText("Definition");
                btn_input.setText("Add");
            }
            case edit -> {
                label_title.setText("Edit Slang Word");
                label_slangword.setText("SlangWord");
                btn_search.setText("Search");
                label_definition.setText("Definition");
                btn_input.setText("Edit");
            }
            case delete -> {
                label_title.setText("Delete Slang Word");
                label_slangword.setText("SlangWord");
                btn_search.setText("Search");
                label_definition.setVisible(false);
                text_definition.setVisible(false);
                btn_input.setText("Delete");
            }
            case random -> {
                label_title.setText("Random Slang Word");
                text_slangword.setVisible(false);
                text_definition.setVisible(false);
                label_slangword.setVisible(false);
                btn_search.setVisible(false);
                label_definition.setVisible(false);
                btn_input.setText("Random");
            }
        }
        this.setContentPane(jPanel);
        this.setVisible(true);
    }

    public void Question() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        label_title = new JLabel("", JLabel.CENTER);
        label_title.setFont(new Font("Arial", Font.PLAIN, 30));
        jPanel.add(label_title, BorderLayout.NORTH);

        JPanel jPanel_center = new JPanel();
        jPanel_center.setLayout(new BorderLayout());

        JPanel jPanel_center_north = new JPanel();
        jPanel_center_north.setLayout(new GridLayout(2, 1));

        JPanel jPanel_btn = new JPanel();
        btn_input = new JButton("New Question");
        btn_input.addActionListener(ac);
        jPanel_btn.add(btn_input);

        label_slangword = new JLabel("Click button above to make new Question", JLabel.CENTER);

        jPanel_center_north.add(jPanel_btn);
        jPanel_center_north.add(label_slangword);

        jPanel_center.add(jPanel_center_north, BorderLayout.NORTH);

        JPanel jPanel_center_main = new JPanel();
        jPanel_center_main.setLayout(new GridLayout(2, 2, 30, 30));
        btn_a = new JButton("a.");
        btn_b = new JButton("b.");
        btn_c = new JButton("c.");
        btn_d = new JButton("d.");

        btn_a.addActionListener(ac);
        btn_b.addActionListener(ac);
        btn_c.addActionListener(ac);
        btn_d.addActionListener(ac);

        jPanel_center_main.add(btn_a);
        jPanel_center_main.add(btn_b);
        jPanel_center_main.add(btn_c);
        jPanel_center_main.add(btn_d);

        jPanel_center.add(jPanel_center_main);
        jPanel.add(jPanel_center, BorderLayout.CENTER);

        JPanel jPanel_south = new JPanel();
        jPanel_south.setLayout(new FlowLayout());

        btnBack = new JButton("BACK");
        btnBack.addActionListener(ac);

        jPanel_south.add(btnBack);

        jPanel.add(jPanel_south, BorderLayout.SOUTH);

        switch (screen) {
            case questionSW -> label_title.setText("Question SlangWord");
            case questionDE -> label_title.setText("Question Definition");
        }

        this.setContentPane(jPanel);
        this.setVisible(true);
    }


}

