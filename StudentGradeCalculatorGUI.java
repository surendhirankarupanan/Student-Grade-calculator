import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculatorGUI extends JFrame implements ActionListener {

    // GUI components
    private JTextField totalStudentsField;
    private JTextField[] studentNameFields, subject1Fields, subject2Fields, subject3Fields, subject4Fields, subject5Fields;
    private JButton calculateButton;
    private JLabel[] totalLabels, averageLabels, gradeLabels;
    private JLabel highestMarksLabel;
    private int numberOfStudents;

    public StudentGradeCalculatorGUI() {
        // Set up the frame
        setTitle("Student Grade Calculator");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Total number of students
        JLabel totalStudentsLabel = new JLabel("Total Number of Students:");
        totalStudentsLabel.setBounds(20, 20, 200, 30);
        add(totalStudentsLabel);

        totalStudentsField = new JTextField();
        totalStudentsField.setBounds(220, 20, 100, 30);
        add(totalStudentsField);

        // Submit Button
        calculateButton = new JButton("Submit");
        calculateButton.setBounds(330, 20, 100, 30);
        add(calculateButton);
        calculateButton.addActionListener(this);

        // Result Labels
        highestMarksLabel = new JLabel("Student with Highest Marks: ");
        highestMarksLabel.setBounds(20, 540, 400, 30); // Adjusted y position to give more space
        add(highestMarksLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (studentNameFields == null) {
                // Get total number of students
                numberOfStudents = Integer.parseInt(totalStudentsField.getText());

                // Initialize fields for each student
                studentNameFields = new JTextField[numberOfStudents];
                subject1Fields = new JTextField[numberOfStudents];
                subject2Fields = new JTextField[numberOfStudents];
                subject3Fields = new JTextField[numberOfStudents];
                subject4Fields = new JTextField[numberOfStudents];
                subject5Fields = new JTextField[numberOfStudents];
                totalLabels = new JLabel[numberOfStudents];
                averageLabels = new JLabel[numberOfStudents];
                gradeLabels = new JLabel[numberOfStudents];

                int yPosition = 60;

                // Loop through to create fields for each student
                for (int i = 0; i < numberOfStudents; i++) {
                    // Student Name Label and Text Field
                    JLabel nameLabel = new JLabel("Student " + (i + 1) + " Name:");
                    nameLabel.setBounds(20, yPosition, 100, 30);
                    add(nameLabel);

                    studentNameFields[i] = new JTextField();
                    studentNameFields[i].setBounds(130, yPosition, 200, 30);
                    add(studentNameFields[i]);

                    // Subject 1
                    JLabel subject1Label = new JLabel("Subject 1 Marks:");
                    subject1Label.setBounds(20, yPosition + 40, 100, 30);
                    add(subject1Label);

                    subject1Fields[i] = new JTextField();
                    subject1Fields[i].setBounds(130, yPosition + 40, 200, 30);
                    add(subject1Fields[i]);

                    // Subject 2
                    JLabel subject2Label = new JLabel("Subject 2 Marks:");
                    subject2Label.setBounds(20, yPosition + 80, 100, 30);
                    add(subject2Label);

                    subject2Fields[i] = new JTextField();
                    subject2Fields[i].setBounds(130, yPosition + 80, 200, 30);
                    add(subject2Fields[i]);

                    // Subject 3
                    JLabel subject3Label = new JLabel("Subject 3 Marks:");
                    subject3Label.setBounds(20, yPosition + 120, 100, 30);
                    add(subject3Label);

                    subject3Fields[i] = new JTextField();
                    subject3Fields[i].setBounds(130, yPosition + 120, 200, 30);
                    add(subject3Fields[i]);

                    // Subject 4
                    JLabel subject4Label = new JLabel("Subject 4 Marks:");
                    subject4Label.setBounds(20, yPosition + 160, 100, 30);
                    add(subject4Label);

                    subject4Fields[i] = new JTextField();
                    subject4Fields[i].setBounds(130, yPosition + 160, 200, 30);
                    add(subject4Fields[i]);

                    // Subject 5
                    JLabel subject5Label = new JLabel("Subject 5 Marks:");
                    subject5Label.setBounds(20, yPosition + 200, 100, 30);
                    add(subject5Label);

                    subject5Fields[i] = new JTextField();
                    subject5Fields[i].setBounds(130, yPosition + 200, 200, 30);
                    add(subject5Fields[i]);

                    // Result Labels
                    totalLabels[i] = new JLabel("Total Marks: ");
                    totalLabels[i].setBounds(350, yPosition, 200, 30);
                    add(totalLabels[i]);

                    averageLabels[i] = new JLabel("Average Marks: ");
                    averageLabels[i].setBounds(350, yPosition + 40, 200, 30);
                    add(averageLabels[i]);

                    gradeLabels[i] = new JLabel("Grade: ");
                    gradeLabels[i].setBounds(350, yPosition + 80, 200, 30);
                    add(gradeLabels[i]);

                    // Adjust position for next student
                    yPosition += 250;
                }

                calculateButton.setText("Calculate");
                this.setSize(800, yPosition + 100);
                repaint();
            } else {
                // Calculate total, average, and grade for each student
                double highestAverage = 0;
                String highestScorer = "";

                for (int i = 0; i < numberOfStudents; i++) {
                    String studentName = studentNameFields[i].getText();
                    int subject1 = Integer.parseInt(subject1Fields[i].getText());
                    int subject2 = Integer.parseInt(subject2Fields[i].getText());
                    int subject3 = Integer.parseInt(subject3Fields[i].getText());
                    int subject4 = Integer.parseInt(subject4Fields[i].getText());
                    int subject5 = Integer.parseInt(subject5Fields[i].getText());

                    // Calculate total and average
                    int total = subject1 + subject2 + subject3 + subject4 + subject5;
                    double average = total / 5.0;
                    char grade;

                    // Determine grade
                    if (average >= 90) {
                        grade = 'A';
                    } else if (average >= 80) {
                        grade = 'B';
                    } else if (average >= 70) {
                        grade = 'C';
                    } else if (average >= 60) {
                        grade = 'D';
                    } else {
                        grade = 'F';
                    }

                    // Update total, average, and grade labels
                    totalLabels[i].setText("Total Marks: " + total);
                    averageLabels[i].setText("Average Marks: " + String.format("%.2f", average));
                    gradeLabels[i].setText("Grade: " + grade);

                    // Track highest average
                    if (average > highestAverage) {
                        highestAverage = average;
                        highestScorer = studentName;
                    }
                }

                // Display student with highest marks
                highestMarksLabel.setText("Student with Highest Marks: " + highestScorer + " (Avg: " + String.format("%.2f", highestAverage) + ")");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for marks.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Create and show the GUI
        StudentGradeCalculatorGUI calculator = new StudentGradeCalculatorGUI();
        calculator.setVisible(true);
    }
}
