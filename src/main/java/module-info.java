module com.example.calcoexam {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.calcoexam to javafx.fxml;
    exports com.example.calcoexam;
}