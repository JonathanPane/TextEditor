package com.example.texteditor.project.library;

public class StageConfiguration{
    private String title, bean_name, path_to_fxml;
    private int min_width, min_height;
    private boolean resizable, wait_termination, modality, creating_bean,resize_min;
    private StageConfiguration(){
        min_height = 0;
        min_width = 0;
        resize_min = false;
        modality = false;
        title = "Title!";
        bean_name = "None";
        resizable = true;
        path_to_fxml = null;
        wait_termination = false;
        creating_bean = false;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private final StageConfiguration res;
        private Builder(){
            res = new StageConfiguration();
        }
        public Builder title(String title){
            res.title = title;
            return this;
        }
        public Builder bean_name(String bean_name){
            res.bean_name = bean_name;
            res.creating_bean = true;
            return this;
        }
        public Builder make_resize_min(){
            res.resize_min = true;
            return this;
        }
        public Builder min_dimension(int min_width, int min_height){
            res.min_width = min_width;
            res.min_height = min_height;
            return this;
        }
        public Builder make_non_resizable(){
            res.resizable = false;
            return this;
        }
        public Builder path_to_fxml(String path_to_fxml){
            res.path_to_fxml = path_to_fxml;
            return this;
        }
        public Builder show_and_wait(){
            res.wait_termination = true;
            return this;
        }
        public Builder set_modality(){
            res.modality = true;
            return this;
        }
        public StageConfiguration build(){
            return res;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBean_name(String bean_name) {
        this.bean_name = bean_name;
    }

    public void setPath_to_fxml(String path_to_fxml) {
        this.path_to_fxml = path_to_fxml;
    }

    public int getMin_width() {
        return min_width;
    }

    public void setMin_width(int min_width) {
        this.min_width = min_width;
    }

    public int getMin_height() {
        return min_height;
    }

    public void setMin_height(int min_height) {
        this.min_height = min_height;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public void setWait_termination(boolean wait_termination) {
        this.wait_termination = wait_termination;
    }

    public void setCreating_bean(boolean creating_bean) {
        this.creating_bean = creating_bean;
    }

    public boolean isResize_min() {
        return resize_min;
    }

    public void setResize_min(boolean resize_min) {
        this.resize_min = resize_min;
    }

    public boolean isModality() {
        return modality;
    }

    public void setModality(boolean modality) {
        this.modality = modality;
    }

    public String getTitle() {
        return title;
    }

    public String getBean_name() {
        return bean_name;
    }

    public String getPath_to_fxml() {
        return path_to_fxml;
    }

    public boolean isResizable() {
        return resizable;
    }

    public boolean isWait_termination(){
        return wait_termination;
    }

    public boolean isCreating_bean(){
        return creating_bean;
    }
}