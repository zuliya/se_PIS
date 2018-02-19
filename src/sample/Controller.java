package sample;

import javafx.beans.property.SimpleStringProperty;
import  sample.sql;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;


public class Controller implements Initializable {

    @FXML private TableView<Patient> patientViewTable;
    @FXML private TableColumn<Patient, String> patientID;
    @FXML private TableColumn<Patient, String> patientName;
    @FXML private TableColumn<Patient, String> patientSurname;
    @FXML private TableColumn<Patient, String> patientDOB;
    @FXML private TableColumn<Patient, String> patiendAddress;
    @FXML private TableColumn<Patient, String> patientPhoneNum;


    @FXML private  TextField name_search;
//    @FXML private  TextField search_DOB;
//    @FXML private  TextField patientID_search;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            updateTable(sql.shared.getPatients());
            patientID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().patientId));
            patientName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
            patientSurname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().surname));
            patientDOB.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().dob));
            patiendAddress.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().address));
            patientPhoneNum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().phoneNum));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void search_btn_action (){
        String name = name_search.getText();

        System.out.print(name);
    }

    public void updateTable (ArrayList<Patient> patients){
            ObservableList<Patient> patientsTableView = FXCollections.observableArrayList();
            patientsTableView.addAll(patients);
            patientViewTable.setItems(patientsTableView);
    }

}

