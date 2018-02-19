package sample;

/**
 * Created by Zuzukina on 09/02/2018.
 */
public class Patient {

    public String patientId;
    public String name;
    public String surname;
    public String dob;
    public String address;
    public String phoneNum;

    public Patient(String patientID,String name, String surname, String dob,String address,String phoneNum)
    {
        this.patientId = patientID;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.phoneNum=phoneNum;
    }
}
