import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Controller implements ActionListener {
    private View view;
    private slangWord sw;
    private List<String> QA;

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
                HashMap<String, String> listSlangword = sw.History();
                if (listSlangword != null) {
                    for (String slangword : listSlangword.keySet()) {
                        String definition = listSlangword.get(slangword);
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
            if(checkFlank(text_value,text_value)) return;
            view.model.setNumRows(0);
            HashMap<String, String> history = new HashMap<String, String>();
            switch (view.screen) {
                case searchByDefinition -> {
                    HashMap<String, String> listSlangword = sw.SearchByDefinition(text_value);
                    if (listSlangword != null) {
                        for (String slangword : listSlangword.keySet()) {
                            String definition = listSlangword.get(slangword);
                            view.model.addRow(new Object[]{slangword, definition});
                            history.put(slangword, definition);
                        }
                    }
                    try {
                        sw.file.WriteFile(history, "history.txt");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case add, edit, delete, searchBySlangword -> {
                    String definition = sw.SearchBySlangWord(text_value);
                    if (definition != null) {
                        view.model.addRow(new Object[]{text_value, definition});
                        history.put(text_value, definition);
                        try {
                            sw.SaveHistory(history);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        } else if (e.getSource() == view.btn_input) {
            String slangword = "";
            String definition = "";
            switch (view.screen) {
                case add, edit, delete, random, history -> {
                    slangword = view.text_slangword.getText();
                    definition = view.text_definition.getText();
                    view.model.setNumRows(0);
                }
            }
            switch (view.screen) {
                case history -> {
                    try {
                        sw.ResetHistory();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case add -> {
                    if(checkFlank(slangword,definition)) return;
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
                    if(checkFlank(slangword,definition)) return;
                    try {
                        sw.EditSlangWord(slangword, definition);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case delete -> {
                    if(checkFlank(slangword,slangword)) return;
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
                    definition = sw.SearchBySlangWord(slangword);
                    view.model.addRow(new Object[]{slangword, definition});
                }
                case questionSW -> {
                    QA = sw.QuestionSlangword();

                    view.label_slangword.setText("What is the definition of \'" + QA.get(0) + "\'");
                    Random random = new Random();
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(1);
                    list.add(2);
                    list.add(3);
                    list.add(4);
                    int idx;
                    int i = 0;
                    while (i < 4) {
                        idx = random.nextInt(list.size());
                        if (i == 0) view.btn_a.setText(QA.get(list.get(idx)));
                        else if (i == 1) view.btn_b.setText(QA.get(list.get(idx)));
                        else if (i == 2) view.btn_c.setText(QA.get(list.get(idx)));
                        else if (i == 3) view.btn_d.setText(QA.get(list.get(idx)));
                        list.remove(idx);
                        i++;
                    }
                }
                case questionDE -> {
                    QA = sw.QuestionDefinition();

                    view.label_slangword.setText("What is the slang word of \'" + QA.get(0) + "\'");
                    Random random = new Random();
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(1);
                    list.add(2);
                    list.add(3);
                    list.add(4);
                    int idx;
                    int i = 0;
                    while (i < 4) {
                        idx = random.nextInt(list.size());
                        if (i == 0) view.btn_a.setText(QA.get(list.get(idx)));
                        else if (i == 1) view.btn_b.setText(QA.get(list.get(idx)));
                        else if (i == 2) view.btn_c.setText(QA.get(list.get(idx)));
                        else if (i == 3) view.btn_d.setText(QA.get(list.get(idx)));
                        list.remove(idx);
                        i++;
                    }
                }
            }
        } else if (e.getSource() == view.btn_a) {
            QAMessage(view.btn_a.getText());
        } else if (e.getSource() == view.btn_b) {
            QAMessage(view.btn_b.getText());
        } else if (e.getSource() == view.btn_c) {
            QAMessage(view.btn_c.getText());
        } else if (e.getSource() == view.btn_d) {
            QAMessage(view.btn_d.getText());
        }
    }

    private void QAMessage(String Answer) {
        String Question = QA.get(0);
        String message = "Your answer is wrong!!!";
        String title = "WRONG";
        switch (view.screen) {
            case questionSW -> {
                if (Answer == sw.SearchBySlangWord(Question)) {
                    message = "Congratulations,Your answer is correct!!!";
                    title = "CORRECT";
                }
            }
            case questionDE -> {
                if (Question == sw.SearchBySlangWord(Answer)) {
                    message = "Congratulations,Your answer is correct!!!";
                    title = "CORRECT";
                }
            }
        }
        JOptionPane.showMessageDialog(view,
                message,
                title,
                JOptionPane.PLAIN_MESSAGE);
    }

    private boolean checkFlank(String slangword,String definition){
        if (slangword.compareTo("") == 0|| definition.compareTo("") == 0){
            JOptionPane.showMessageDialog(view,
                    "Please fill slang word or definition to add",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }
}
