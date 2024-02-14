package com.example.calcoexam;

import java.sql.*;

public class StudentDAO {

    public static void main(String[] args) {

        addStudent();
    }
    public static void addStudent() {

        String url = "jdbc:sqlite:StudentGrade.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
        String[] studentNames = {"Alice", "Bob", "Charlie", "David", "Eve"};
        String[] departments = {"Computer Science", "Physics", "Mathematics", "Chemistry", "Biology"};

        for (int i = 0; i < 5; i++) {
            // Insert student
            String insertStudentSql = String.format("INSERT INTO students (name, department) " +
                            "VALUES ('%s', '%s')",
                    studentNames[i], departments[i]);
            stmt.execute(insertStudentSql);
            System.out.println("Inserted student: " + studentNames[i]);

            // Insert grades for each student
            for (int j = 1; j <= 6; j++) {
                int grade = (int) (Math.random() * 90) + 1; // Random grade between 1 and 90
                String insertGradeSql = String.format("UPDATE students SET grade_course_%d = %d " +
                                "WHERE name = '%s'",
                        j, grade, studentNames[i]);
                stmt.execute(insertGradeSql);
                System.out.println("Inserted grade " + grade + " for course " + j + " for student " + studentNames[i]);
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    }
}
