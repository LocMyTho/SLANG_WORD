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
            view.screen = View.Screen.searchBySlangword;
            view.view();
        } else if (e.getSource() == view.btnSearchByDefinition) {
            view.screen = View.Screen.searchByDefinition;
            view.view();
        } else if (e.getSource() == view.btnHistory) {
            view.screen = View.Screen.history;
            view.view();
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
            view.screen = View.Screen.add;
            view.view();
        } else if (e.getSource() == view.btnEditSlangWord) {
            view.screen = View.Screen.edit;
            view.view();
        } else if (e.getSource() == view.btnDeleteSlangWord) {
            view.screen = View.Screen.delete;
            view.view();
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
            if (n == 0) {
                try {
                    sw.ResetSlangWordList();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (e.getSource() == view.btnRandomSlangWord) {
            view.screen = View.Screen.random;
            view.view();
        } else if (e.getSource() == view.btnQuestionSlangWord) {
            view.screen = View.Screen.questionSW;
            view.Question();
        } else if (e.getSource() == view.btnQuestionDefinition) {
            view.screen = View.Screen.questionDE;
            view.Question();
        } else if (e.getSource() == view.btn_search) {
            String text_value = view.text_slangword.getText();
            view.model.setNumRows(0);
            switch (view.screen) {
                case searchByDefinition -> {
                    HashMap<String, List<String>> listSlangword = sw.SearchByDefinition(text_value);
                    if (listSlangword != null) {
                        for (String slangword : listSlangword.keySet()) {
                            text_value = String.join(" | ", listSlangword.get(slangword));
                            view.model.addRow(new Object[]{slangword, text_value});
                            try {
                                sw.SaveHistory(slangword, listSlangword.get(slangword));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
                case add,edit,delete,searchBySlangword ->{
                    List<String> listDefinition = sw.SearchBySlangWord(text_value);
                    if (listDefinition != null) {
                        String definition = String.join(" | ", listDefinition);
                        view.model.addRow(new Object[]{text_value, definition});
                        try {
                            sw.SaveHistory(text_value, listDefinition);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        } else if (e.getSource() == view.btn_input) {
            String slangword = view.text_slangword.getText();
            String definition = view.text_definition.getText();
            view.model.setNumRows(0);
            switch (view.screen) {
                case history -> {
                    try {
                        sw.ResetHistory();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case add -> {
                    int check = 0;
                    for (String i : sw.sw.keySet()) {
                        if (slangword.compareTo(i) == 0) {
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
                case edit -> {
                    try {
                        sw.EditSlangWord(slangword, definition);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case delete -> {
                    Object[] options = {"Confirm", "No"};
                    int n = JOptionPane.showOptionDialog(view,
                            "Do you want to delete this slang word",
                            "Delete slang word",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[1]);
                    if (n == 0) {
                        try {
                            sw.DeleteSlangWord(slangword);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                case random -> {
                    slangword = sw.RandomSlangWord();
                    definition = String.join(" | ", sw.SearchBySlangWord(slangword));
                    view.model.addRow(new Object[]{slangword, definition});
                }
                case questionSW -> {

                } case questionDE -> {

                }
            }
        } else if (e.getSource() == view.btn_a) {

        }
    }
}
