import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view;

    public Controller(View view) {
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("BACK") == 0) {
            view.Menu();
        } else if (e.getActionCommand().compareTo("Search By SlangWord") == 0) {
            view.SearchBySlangWord();
        } else if (e.getActionCommand().compareTo("Search By Definition") == 0) {
            view.SearchByDefinition();
        } else if (e.getActionCommand().compareTo("History") == 0) {
            view.History();
        } else if (e.getActionCommand().compareTo("Add New SlangWord") == 0) {
            view.AddNewSlangWord();
            Object[] options = {"Confirm", "No"};
            int n = JOptionPane.showOptionDialog(view,
                    "Do you want to add this slang word",
                    "Add new slang word",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
        } else if (e.getActionCommand().compareTo("Edit SlangWord") == 0) {
            view.EditSlangWord();
        } else if (e.getActionCommand().compareTo("Delete SlangWord") == 0) {
            view.DeleteSlangWord();
        } else if (e.getActionCommand().compareTo("Reset SlangWord List") == 0) {
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(view,
                    "Do you want to reset slang word list",
                    "Reset slang word list",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
        } else if (e.getActionCommand().compareTo("Random SlangWord") == 0) {
            view.RandomSlangWord();
        }
    }
}
