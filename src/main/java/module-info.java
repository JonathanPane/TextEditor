module com.example.texteditor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.texteditor to javafx.fxml;
    exports com.example.texteditor;
    exports com.example.texteditor.controllers;
    opens com.example.texteditor.controllers to javafx.fxml;
}