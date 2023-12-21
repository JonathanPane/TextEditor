package com.example.texteditor.controllers;

import com.example.texteditor.BeanContext;
import com.example.texteditor.services.FileIOService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainPageController {



    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private MenuBar menu_bar;
    @FXML
    private TextArea text_field;

    @FXML
    void close() {
        BeanContext.<Stage>get_bean("MainPage").close();
    }

    @FXML
    void file() {
    }

    @FXML
    void open_file() throws FileNotFoundException {
        FileIOService.open_file(text_field);
    }

    @FXML
    void save_file_as() throws IOException {
        FileIOService.save_file_as(text_field);
    }
    @FXML
    void save_file() throws IOException {
        FileIOService.save_file(text_field);
    }

}
