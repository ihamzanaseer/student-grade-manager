// === GUI_AddView.java ===
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class GUI_AddView {
    private ArrayList<Student> studentList;
    private TextField nameField, studentIdField, Subject1Field, Subject2Field, Subject3Field, AverageField, GradeField;
    private TextArea ViewAllTextArea;

    public GUI_AddView(ArrayList<Student> studentList,
                       TextField nameField, TextField studentIdField,
                       TextField Subject1Field, TextField Subject2Field, TextField Subject3Field,
                       TextField AverageField, TextField GradeField,
                       TextArea ViewAllTextArea) {
        this.studentList = studentList;
        this.nameField = nameField;
        this.studentIdField = studentIdField;
        this.Subject1Field = Subject1Field;
        this.Subject2Field = Subject2Field;
        this.Subject3Field = Subject3Field;
        this.AverageField = AverageField;
        this.GradeField = GradeField;
        this.ViewAllTextArea = ViewAllTextArea;
    }

    public void handleAdd() {
        try {
            String name = nameField.getText().trim();
            String id = studentIdField.getText().trim();
            int s1 = Integer.parseInt(Subject1Field.getText().trim());
            int s2 = Integer.parseInt(Subject2Field.getText().trim());
            int s3 = Integer.parseInt(Subject3Field.getText().trim());

            Student s = new Student(name, id, s1, s2, s3);
            studentList.add(s);

            AverageField.setText(String.format("%.2f", s.getAverage()));
            GradeField.setText(s.getGrade());
        } catch (Exception ex) {
            AverageField.setText("Invalid input!");
            GradeField.setText("-");
        }
    }

    public void handleViewAll() {
        ViewAllTextArea.setText("");
        for (Student s : studentList) {
            ViewAllTextArea.append(s.toString() + "\n");
        }
    }

    public static class Student {
        String name, id;
        int s1, s2, s3;

        public Student(String name, String id, int s1, int s2, int s3) {
            this.name = name;
            this.id = id;
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        double getAverage() {
            return (s1 + s2 + s3) / 3.0;
        }

        String getGrade() {
            double avg = getAverage();
            if (avg >= 85) return "A";
            else if (avg >= 70) return "B";
            else if (avg >= 60) return "C";
            else if (avg >= 50) return "D";
            else return "F";
        }

        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Marks: " + s1 + ", " + s2 + ", " + s3 +
                   " | Avg: " + String.format("%.2f", getAverage()) + " | Grade: " + getGrade();
        }
    }
}