import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Controller implements ActionListener {
    private View view;
    private slangWord sw;

    public Controller(View view) throws IOException {
        this.view = view;
        this.sw = new slangWord();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnBack) {
            view.Menu();
        } else if (e.getSource() == view.btnSearchBySlangWord) {
            view.SearchBySlangWord();
        } else if (e.getSource() == view.btnSearchByDefinition) {
            view.SearchByDefinition();
        } else if (e.getSource() == view.btnHistory) {
            view.History();
            view.model.setNumRows(0);
            try {
                HashMap<String, List<String>> listSlangword = sw.History();
                if (listSlangword != null) {
                    for (String slangword : listSlangword.keySet()) {
                        String definition = String.join(" | ", listSlangword.get(slangword));
                        view.model.addRow(new Object[]{slangword, definition});
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource() == view.btnAddNewSlangWord) {
            view.AddNewSlangWord();
        } else if (e.getSource() == view.btnEditSlangWord) {
            view.EditSlangWord();
        } else if (e.getSource() == view.btnDeleteSlangWord) {
            view.DeleteSlangWord();
        } else if (e.getSource() == view.btnResetSlangWordList) {
            Object[] options = {"Yes", "No"};
            int n = JOptionPane.showOptionDialog(view,
                    "Do you want to reset slang word list",
                    "Reset slang word list",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
        } else if (e.getSource() == view.btnRandomSlangWord) {
            view.RandomSlangWord();
        } else if (e.getSource() == view.btn_searchBySlangword) {
            String slangword = view.text_slangword.getText();
            List<String> listDefinition = sw.SearchBySlangWord(slangword);
            view.model.setNumRows(0);
            if (listDefinition != null) {
                String definition = String.join(" | ", listDefinition);
                view.model.addRow(new Object[]{slangword, definition});
            }
        } else if (e.getSource() == view.btn_searchByDefinition) {
            String definition = view.text_definition.getText();
            HashMap<String, List<String>> listSlangword = sw.SearchByDefinition(definition);
            view.model.setNumRows(0);
            if (listSlangword != null) {
                for (String slangword : listSlangword.keySet()) {
                    definition = String.join(" | ", listSlangword.get(slangword));
                    view.model.addRow(new Object[]{slangword, definition});
                }
            }
        } else if (e.getSource() == view.btnAdd) {
            String slangword = view.text_slangword.getText();
            String definition = view.text_definition.getText();

            int check = 0;
            for (String i : sw.sw.keySet()) {
                if (slangword == i) {
                    check++;
                }
            }
            if (check == 0) {
                Object[] options = {"Confirm", "No"};
                int n = JOptionPane.showOptionDialog(view,
                        "Do you want to add this slang word",
                        "Add new slang word",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
                if (n == 0) {
                    try {
                        sw.AddNewSlangWord(slangword, definition, "Confirm");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } else {
                Object[] options = {"duplicate", "overwrite", "No"};
                int n = JOptionPane.showOptionDialog(view,
                        "Do you want to duplicate or overwrite this slang word",
                        "Add new slang word",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]);

                try {
                    if (n == 0) {
                        sw.AddNewSlangWord(slangword, definition, "duplicate");
                    } else if (n == 1) {
                        sw.AddNewSlangWord(slangword, definition, "overwrite");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);

                }
            }
        }
    }
}
