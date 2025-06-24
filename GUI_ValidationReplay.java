// === GUI_ValidationReplay.java ===
import java.awt.TextField;
import java.util.regex.Pattern;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI_ValidationReplay {
    private TextField nameField, studentIdField, Subject1Field, Subject2Field, Subject3Field, AverageField, GradeField;
    private JFrame frame;

    public GUI_ValidationReplay(JFrame frame,
                                TextField nameField, TextField studentIdField,
                                TextField Subject1Field, TextField Subject2Field, TextField Subject3Field,
                                TextField AverageField, TextField GradeField) {
        this.frame = frame;
        this.nameField = nameField;
        this.studentIdField = studentIdField;
        this.Subject1Field = Subject1Field;
        this.Subject2Field = Subject2Field;
        this.Subject3Field = Subject3Field;
        this.AverageField = AverageField;
        this.GradeField = GradeField;
    }

    public boolean validateInputs() {
        String name = nameField.getText().trim();
        String id = studentIdField.getText().trim();
        String s1Text = Subject1Field.getText().trim();
        String s2Text = Subject2Field.getText().trim();
        String s3Text = Subject3Field.getText().trim();

        if (name.isEmpty() || !Pattern.matches("[a-zA-Z ]+", name)) {
            AverageField.setText("Invalid name");
            GradeField.setText("-");
            return false;
        }

        if (id.isEmpty() || !Pattern.matches("[a-zA-Z0-9]+", id)) {
            AverageField.setText("Invalid ID");
            GradeField.setText("-");
            return false;
        }

        try {
            int s1 = Integer.parseInt(s1Text);
            int s2 = Integer.parseInt(s2Text);
            int s3 = Integer.parseInt(s3Text);

            if (s1 < 0 || s1 > 100 || s2 < 0 || s2 > 100 || s3 < 0 || s3 > 100) {
                AverageField.setText("Marks 0–100 only");
                GradeField.setText("-");
                return false;
            }

        } catch (NumberFormatException e) {
            AverageField.setText("Marks must be numbers");
            GradeField.setText("-");
            return false;
        }

        return true;
    }

    public void showReplayOption() {
        int choice = JOptionPane.showConfirmDialog(
            frame,
            "Do you want to continue using the system?",
            "Continue?",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
}