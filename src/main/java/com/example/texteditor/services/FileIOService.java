package com.example.texteditor.services;

import com.example.texteditor.BeanContext;
import com.example.texteditor.project.library.ProjectFoundation;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileIOService {
    private static boolean file_opened = false;

    public static void open_file(TextArea textArea) throws FileNotFoundException {
        File file = ProjectFoundation.select_file("*.txt",
                "*.docx",
                "*.rtf",
                "Файл",
                false);
        String str = "";
        if (file != null) {
            if(BeanContext.contains_bean("path to file"))
                 BeanContext.set_value_in_bean(("path to file"),file.getPath());
            else BeanContext.register_bean("path to file",file.getPath());
            Scanner scanner = new Scanner(new FileInputStream(file));
            while (scanner.hasNextLine()) {
                str += scanner.nextLine() + "\n";
                textArea.setText(str);
            }
            file_opened = true;
            scanner.close();
        }
    }
    public static void save_file_as(TextArea textArea) throws IOException {
        File saving_file = ProjectFoundation.select_file("*.txt",
                "*.docx",
                "*.rtf",
                "Файл",
                true);
        if(saving_file != null) {
            if(!BeanContext.contains_bean("path to file")) {
                BeanContext.register_bean("path to file", saving_file.getPath());
                saving_file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(saving_file);
                fileOutputStream.write(textArea.getText().getBytes(StandardCharsets.UTF_8));
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            else{
                BeanContext.set_value_in_bean("path to file", saving_file.getPath());
                saving_file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(saving_file);
                fileOutputStream.write(textArea.getText().getBytes(StandardCharsets.UTF_8));
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
    }
    public static void save_file(TextArea textArea) throws IOException {
        if(file_opened) {
            File file = new File(BeanContext.get_bean("path to file").toString());
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(file),true);
            printWriter.println(textArea.getText());
            printWriter.close();
        }
        else save_file_as(textArea);
        file_opened = true;
    }
}
