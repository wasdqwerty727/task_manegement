package com.example.demo7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private ListView<Task> listView;
    ObservableList<Task> tasks = FXCollections.observableArrayList();

    public void initialize(){
        // Initialize the ListView
        listView.setItems(tasks);
    }

    @FXML
    private TextField inputName;
    @FXML
    private TextField inputDesc;
    @FXML
    private Label label;
    @FXML
    private RadioButton taskHW, taskM, taskSH;
    @FXML
    private RadioButton prLOW, prMD, prHIGH;
    @FXML
    private CheckBox checkBox;
    @FXML
    private DatePicker deadline;

    @FXML
    protected void onListViewSelected() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Task selectedTask = tasks.get(selectedIndex);
            label.setText("" + selectedIndex);

            if (selectedTask instanceof HomewiorkTask) {
                taskHW.setSelected(true);
            } else if (selectedTask instanceof MeetingTask) {
                taskM.setSelected(true);
            } else if (selectedTask instanceof ShoppingTask) {
                taskSH.setSelected(true);
            }

            Priority taskPriority = selectedTask.getPriority();

            switch (taskPriority) {
                case LOW:
                    prLOW.setSelected(true);
                    prMD.setSelected(false);
                    prHIGH.setSelected(false);
                    break;
                case MEDIUM:
                    prLOW.setSelected(false);
                    prMD.setSelected(true);
                    prHIGH.setSelected(false);
                    break;
                case HIGH:
                    prLOW.setSelected(false);
                    prMD.setSelected(false);
                    prHIGH.setSelected(true);
                    break;
            }

            inputName.setText(selectedTask.getTaskName());
            inputDesc.setText(selectedTask.getDescription());
        }
    }

    @FXML
    protected void onSaveButtonClick(){
        String name = inputName.getText();
        String description = inputDesc.getText();
        if (name.isEmpty() || description.isEmpty()){
            label.setText("Please enter a name and description for the task.");
        }
         else {
            if (taskHW.isSelected()){
                if (prLOW.isSelected()) {
                    HomewiorkTask ht = new HomewiorkTask();
                    Priority pr = Priority.LOW;
                    ht.createTask(inputName.getText(), inputDesc.getText());
                    ht.setPriority(pr);
                    tasks.add(ht);
                    inputName.setText("");
                    inputDesc.setText("");
                } else if (prMD.isSelected()) {
                    HomewiorkTask ht = new HomewiorkTask();
                    Priority pr = Priority.MEDIUM;
                    ht.createTask(inputName.getText(), inputDesc.getText());
                    ht.setPriority(pr);
                    tasks.add(ht);
                    inputName.setText("");
                    inputDesc.setText("");
                } else if (prHIGH.isSelected()) {
                    HomewiorkTask ht = new HomewiorkTask();
                    Priority pr = Priority.HIGH;
                    ht.createTask(inputName.getText(), inputDesc.getText());
                    ht.setPriority(pr);
                    tasks.add(ht);
                    inputName.setText("");
                    inputDesc.setText("");
                } else {
                    label.setText("Please select a priority for homework tasks");
                }
            } else if (taskM.isSelected()) {
                if (prLOW.isSelected()){
                    MeetingTask mt = new MeetingTask();
                    Priority pr = Priority.LOW;
                    mt.createTask(inputName.getText(), inputDesc.getText());
                    mt.setPriority(pr);
                    tasks.add(mt);
                    inputName.setText("");
                    inputDesc.setText("");
                } else if (prMD.isSelected()) {
                    MeetingTask mt = new MeetingTask();
                    Priority pr = Priority.MEDIUM;
                    mt.createTask(inputName.getText(), inputDesc.getText());
                    mt.setPriority(pr);
                    tasks.add(mt);
                    inputName.setText("");
                    inputDesc.setText("");
                } else if (prHIGH.isSelected()) {
                    MeetingTask mt = new MeetingTask();
                    Priority pr = Priority.HIGH;
                    mt.createTask(inputName.getText(), inputDesc.getText());
                    mt.setPriority(pr);
                    tasks.add(mt);
                    inputName.setText("");
                    inputDesc.setText("");
                } else {
                    label.setText("Please select a priority for meeting tasks");
                }
            } else if (taskSH.isSelected()) {
                if (prLOW.isSelected()){
                    ShoppingTask sh = new ShoppingTask();
                    Priority pr = Priority.LOW;
                    sh.createTask(inputName.getText(), inputDesc.getText());
                    sh.setPriority(pr);
                    tasks.add(sh);
                    inputName.setText("");
                    inputDesc.setText("");
                } else if (prMD.isSelected()) {
                    ShoppingTask sh = new ShoppingTask();
                    Priority pr = Priority.MEDIUM;
                    sh.createTask(inputName.getText(), inputDesc.getText());
                    sh.setPriority(pr);
                    tasks.add(sh);
                    inputName.setText("");
                    inputDesc.setText("");
                } else if (prHIGH.isSelected()) {
                    ShoppingTask sh = new ShoppingTask();
                    Priority pr = Priority.HIGH;
                    sh.createTask(inputName.getText(), inputDesc.getText());
                    sh.setPriority(pr);
                    tasks.add(sh);
                    inputName.setText("");
                    inputDesc.setText("");
                } else {
                    label.setText("Please select a priority for meeting tasks");
                }

            } else{
                label.setText("Please select a task");
            }
        }
    }

    @FXML
    protected void onDeleteClick() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tasks.remove(selectedIndex);
            listView.getSelectionModel().clearSelection();
            inputName.setText("");
            inputDesc.setText("");
        } else {
            label.setText("Error no selected in ListView");
        }
    }

    @FXML
    protected void onCheckBoxClick() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Task selectedTask = tasks.get(selectedIndex);
            selectedTask.markAsComplete();
            listView.refresh();
            // Update the UI or perform any other necessary actions.
        }
    }

}