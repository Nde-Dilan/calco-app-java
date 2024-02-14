package com.example.calcoexam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:StudentGrade.db"; // Change this to your desired database name

    public static void main(String[] args) {
        try {
            // Attempt to establish a connection to the database
            Connection connection = getConnection();

            // If the connection is successful, print a success message
            System.out.println("Connected to the database successfully!");
//            createTables();
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            // If an SQLException occurs, print the error message
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTables() {
        try (Connection conn = getConnection();
             Statement statement = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "department TEXT NOT NULL," +
                    "grade_course_1 INTEGER," +
                    "grade_course_2 INTEGER," +
                    "grade_course_3 INTEGER," +
                    "grade_course_4 INTEGER," +
                    "grade_course_5 INTEGER," +
                    "grade_course_6 INTEGER" +
                    ")";

            statement.executeUpdate(sql);

            // Create other tables if needed
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
