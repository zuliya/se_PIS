package sample;
import  sample.Patient;

/**
 * Created by Zuzukina on 09/02/2018.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

        import java.sql.PreparedStatement;

        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.HashMap;
        import java.sql.ResultSetMetaData;

public class sql {
    private static String database_name = "SE_PIS";
    private static String host = "jdbc:mysql://localhost:3306/";
    private static String username = "root";
    private static String password = "";

    // Creating sqlconnection singleton
    public static sql shared = new sql();
    private Statement statement;

    public sql () {
        try {
            Connection con = DriverManager.getConnection(host+database_name, username, password);
            System.out.println("Connected to the database");
            this.statement = con.createStatement();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public ArrayList<Patient> getPatients() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM Patient");
        ArrayList<Patient> patients = new ArrayList<Patient>();
        while ( rs.next() ) {
            String patientID = rs.getString("patientID");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String dob = rs.getString("dob");
            String address = rs.getString("address");
            String phoneNum = rs.getString("phoneNum");
//            String riskLevel = rs.getString("riskLevel");
//            String consultant = rs.getString("consultant");
//            String GPAddress = rs.getString("GPAddress");
//            String GPName = rs.getString("GPName");
//            String nextOfKin = rs.getString("nextOfKin");
//            String nextOfKinPhoneNum = rs.getString("nextOfKinPhoneNum");

            patients.add(new Patient(patientID,name,surname,dob,address,phoneNum));
        }
        return patients;
    }

//    public ArrayList<Conditions> getConditions() throws SQLException {
//        ResultSet rs = statement.executeQuery("SELECT * FROM Conditions");
//        ArrayList<Conditions> conditions = new ArrayList<Conditions>();
//        while ( rs.next() ) {
//            String conditionID = rs.getString("conditionID");
//            String condition = rs.getString("condition");
//            conditions.add(new Conditions(conditionID, condition));
//        }
//    }
//
//    public ArrayList<Consulations> getConsulations() throws SQLException {
//        ResultSet rs = statement.executeQuery("SELECT * FROM Consulations");
//        ArrayList<Consulations> consulations = new ArrayList<Consulations>();
//        while ( rs.next() ) {
//            String consultationID = rs.getString("consultationID");
//            String patientID = rs.getString("patientID");
//            String date = rs.getString("date");
//            String location = rs.getString("location");
//            String doctor = rs.getString("doctor");
//            String comment = rs.getString("comment");
//            consulations.add(new Consulations(consultationID,patientID,date,location,doctor,comment));
//        }
//    }
//
//    public ArrayList<Diagnosis> getDiagnosis() throws SQLException {
//        ResultSet rs = statement.executeQuery("SELECT * FROM Diagnosis");
//        ArrayList<Diagnosis> diagnosis = new ArrayList<Diagnosis>();
//        while ( rs.next() ) {
//            String diagnosisID = rs.getString("diagnosisID");
//            String patientID = rs.getString("patientID");
//            String conditionID = rs.getString("conditionID");
//            String date = rs.getString("date");
//            String diagnostician = rs.getString("diagnostician");
//            String comment = rs.getString("comment");
//            diagnosis.add(new Diagnosis(consultationID,patientID,date,location,doctor,comment));
//        }
//    }
}

