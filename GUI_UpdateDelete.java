// === GUI_UpdateDelete.java ===
import java.util.ArrayList;
import java.awt.TextField;

public class GUI_UpdateDelete {
    private ArrayList<GUI_AddView.Student> studentList;
    private TextField studentIdField, Subject1Field, Subject2Field, Subject3Field, AverageField, GradeField;

    public GUI_UpdateDelete(ArrayList<GUI_AddView.Student> studentList,
                            TextField studentIdField, TextField Subject1Field,
                            TextField Subject2Field, TextField Subject3Field,
                            TextField AverageField, TextField GradeField) {
        this.studentList = studentList;
        this.studentIdField = studentIdField;
        this.Subject1Field = Subject1Field;
        this.Subject2Field = Subject2Field;
        this.Subject3Field = Subject3Field;
        this.AverageField = AverageField;
        this.GradeField = GradeField;
    }

    public void handleUpdate() {
        try {
            String id = studentIdField.getText().trim();
            int s1 = Integer.parseInt(Subject1Field.getText().trim());
            int s2 = Integer.parseInt(Subject2Field.getText().trim());
            int s3 = Integer.parseInt(Subject3Field.getText().trim());

            for (GUI_AddView.Student s : studentList) {
                if (s.id.equals(id)) {
                    s.s1 = s1;
                    s.s2 = s2;
                    s.s3 = s3;

                    AverageField.setText(String.format("%.2f", s.getAverage()));
                    GradeField.setText(s.getGrade());
                    return;
                }
            }

            AverageField.setText("Not Found");
            GradeField.setText("-");
        } catch (Exception ex) {
            AverageField.setText("Invalid input!");
            GradeField.setText("-");
        }
    }

    public void handleDelete() {
        String id = studentIdField.getText().trim();
        boolean removed = studentList.removeIf(s -> s.id.equals(id));

        if (removed) {
            AverageField.setText("Deleted");
            GradeField.setText("-");
        } else {
            AverageField.setText("Not Found");
            GradeField.setText("-");
        }
    }
}