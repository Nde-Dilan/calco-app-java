package com.example.calcoexam;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentGradeController {
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtID;

    @FXML
    private Label lblGrade;

    @FXML
    private TextField txtMathGrade;

    @FXML
    private TextField txtScienceGrade;

    @FXML
    private TextField studentIDTextField;

    @FXML
    private TextField studentNameTextField;

    @FXML
    private TextField departmentTextField;

    @FXML
    private TextField course1GradeTextField;
    @FXML
    private TextField course2GradeTextField;
    @FXML
    private TextField course3GradeTextField;
    @FXML
    private TextField course4GradeTextField;
    @FXML
    private TextField course5GradeTextField;
    @FXML
    private TextField course6GradeTextField;

    String course1Grade;
    String course2Grade ;
    String course3Grade ;
    String course4Grade ;
    String course5Grade ;
    String course6Grade;

    @FXML
    private Button add_student_btn;

    @FXML
    private Button reset_all;

    @FXML
    private TextField course1GradeTextField1;

    @FXML
    private TextField course2GradeTextField1;

    @FXML
    private TextField course3GradeTextField1;

    @FXML
    private TextField course4GradeTextField1;

    @FXML
    private TextField course5GradeTextField1;

    @FXML
    private TextField course6GradeTextField1;

    @FXML
    private TextField studentIdTextField;

    @FXML
    private void add_student() {
        // StudentDAO.addStudent();
    }

    @FXML
    private void reset_all() {
        course1GradeTextField.clear();
        course2GradeTextField.clear();
        course3GradeTextField.clear();
        course4GradeTextField.clear();
        course5GradeTextField.clear();
        course6GradeTextField.clear();
        studentNameTextField.clear();
        departmentTextField.clear();
//        studentIdTextField.clear();
        lblGrade.setText("Student Grade: ");
    }





    @FXML
    private Button fetchInfoButton;

    @FXML
    private void addStudent() {
        String name = txtName.getText();
        String id = txtID.getText();
        String mathGrade = txtMathGrade.getText();
        String scienceGrade = txtScienceGrade.getText();

        System.out.println("New student added:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Math Grade: " + mathGrade);
        System.out.println("Science Grade: " + scienceGrade);
    }



    @FXML
    private void fetchStudentInfo() {
        boolean studentFetched = true;
        // Implement logic to fetch student information based on the provided ID

        String studentID = studentIDTextField.getText();
        System.out.println("Fetching student information for ID: " + studentID);






        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set the student ID parameter in the prepared statement
            pstmt.setString(1, studentID);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Check if the result set has any data
            if (rs.next()) {
                // Extract student name and department from the result set
                String studentName = rs.getString("name");
                String department = rs.getString("department");
                 course1Grade = rs.getString("grade_course_1");
                 course2Grade = rs.getString("grade_course_2");
                 course3Grade = rs.getString("grade_course_3");
                 course4Grade = rs.getString("grade_course_4");
                 course5Grade = rs.getString("grade_course_5");
                 course6Grade = rs.getString("grade_course_6");

                System.out.println("Student found with course5Grade: " + course5Grade);
                // Update the UI fields with the fetched information
                updateUI(studentName, department,course1Grade,course2Grade,course3Grade,course4Grade,course5Grade,course6Grade);
            } else {
                // Handle the case where no student with the provided ID is found
                System.out.println("Student not found with ID: " + studentID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateUI(String studentName, String department, String course1Grade, String course2Grade, String course3Grade, String course4Grade, String course5Grade, String course6Grade) {
        studentNameTextField.setText(studentName);
        departmentTextField.setText(department);
        course1GradeTextField.setText(course1Grade);
        course2GradeTextField.setText(course2Grade);
        course3GradeTextField.setText(course3Grade);
        course4GradeTextField.setText(course4Grade);
        course5GradeTextField.setText(course5Grade);
        course6GradeTextField.setText(course6Grade);


//        calculateGrades(totalScore);
    }


    @FXML
    private void calculateGrades() {

        int totalScore = Integer.parseInt(course1Grade) + Integer.parseInt(course2Grade) + Integer.parseInt(course3Grade) + Integer.parseInt(course4Grade) + Integer.parseInt(course5Grade) + Integer.parseInt(course6Grade);

        String grade;
        System.out.println(totalScore/10);
        switch (totalScore / 10) {
            case 10:
                grade = "A";
                break;
            case 9:
                grade = "A";
                break;
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "B";
                break;
            case 6:
                grade = "C";
                break;
            case 5:
                grade = "D";
                break;
            case 4:
                grade = "E";
                break;
            default:
                grade = "A";
        }
        lblGrade.setText("Student Grade: " + grade);
        System.out.println("Calculating grades...");
    }



}
