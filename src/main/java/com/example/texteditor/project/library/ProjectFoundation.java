package com.example.texteditor.project.library;

import com.example.texteditor.BeanContext;
import com.example.texteditor.HelloApplication;
import com.example.texteditor.project.library.StageConfiguration;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ProjectFoundation {
    /**
     * create new window and register this in bean by name of title
     */
    public static void create_new_window_from_fxml(StageConfiguration configuration, String... path_to_stylesheets) throws IOException {
        Stage stage = new Stage();
        if(configuration.isCreating_bean())
            BeanContext.register_bean(configuration.getBean_name(), stage);
        if(configuration.isModality())
            stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(configuration.getTitle());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(configuration.getPath_to_fxml()));
        Scene scene = new Scene(fxmlLoader.load());
        for(String path_to_stylesheet: path_to_stylesheets)
            scene.getStylesheets().add(Objects.requireNonNull(HelloApplication.class.getResource(path_to_stylesheet)).toExternalForm());
        stage.setScene(scene);
        stage.setResizable(configuration.isResizable());
        if(configuration.isResize_min()){
            stage.setMinWidth(configuration.getMin_width());
            stage.setMinHeight(configuration.getMin_height());
        }
        if(configuration.isWait_termination())
            stage.showAndWait();
        else
            stage.show();
    }

    public static void maximizeStageWindow(Stage stage){
        stage.setMaximized(true);
    }

    public static void async(Runnable task){
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    public static File select_file(String extension,String extension1,String extension2, String description, boolean save_mode){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(description, extension,
                extension1,
                extension2
                ));
        if(save_mode)
            return fileChooser.showSaveDialog(BeanContext.get_bean("MainPage"));
        return fileChooser.showOpenDialog(BeanContext.get_bean("MainPage"));
    }
}
