import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        this.setTitle("Slang word");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);

        //header
        JPanel jPanel_header = new JPanel();
        jPanel_header.setLayout(new GridLayout(2, 5));

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

        jPanel_header.add(btnSearchBySlangWord);
        jPanel_header.add(btnSearchByDefinition);
        jPanel_header.add(btnHistory);
        jPanel_header.add(btnAddNewSlangWord);
        jPanel_header.add(btnEditSlangWord);
        jPanel_header.add(btnDeleteSlangWord);
        jPanel_header.add(btnResetSlangWordList);
        jPanel_header.add(btnRandomSlangWord);
        jPanel_header.add(btnQuestionSlangWord);
        jPanel_header.add(btnQuestionDefinition);

        //footer
        JPanel jPanel_footer = new JPanel();

        JButton btnOK = new JButton("OK");

        jPanel_footer.setLayout(new FlowLayout());
        jPanel_footer.add(btnOK);

        //center
        JPanel jPanel_center = new JPanel();

        JLabel label = new JLabel("haha", JLabel.CENTER);

        jPanel_center.setLayout(new GridLayout());
        jPanel_center.add(label);


        this.setLayout(new BorderLayout());
        this.add(jPanel_header, BorderLayout.NORTH);
        this.add(jPanel_footer, BorderLayout.SOUTH);
        this.add(jPanel_center, BorderLayout.CENTER);
    }


}
