package com.example.calcoexam;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentGradeCalculatorApp extends Application {

    @Override

        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(StudentGradeCalculatorApp.class.getResource("StudentGrade.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 880, 500);
//        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
            stage.setTitle("Student Grade Calculator");
        scene.getStylesheets().add("https://raw.githubusercontent.com/antoniopelusi/JavaFX-Dark-Theme/main/style.css");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }


    public static void main(String[] args) {
        launch(args);
    }
}
