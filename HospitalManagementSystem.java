/* complex hierarchical relationships.
Problem 3: Hospital, Doctors, and Patients (Association and Communication)
Description: Model a Hospital where Doctor and Patient objects interact through consultations. A doctor can see multiple patients, and each patient can consult multiple doctors.
Tasks:
Define a Hospital class containing Doctor and Patient classes.
Create a method consult() in the Doctor class to show communication, which would display the consultation between a doctor and a patient.
Model an association between doctors and patients to show that doctors and patients can have multiple relationships.
Goal: Practice creating an association with communication between objects by modeling doctor-patient consultations. */

import java.util.*;
class Patient {
    private String name;
    private ArrayList<Doctor> doctors;  

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }
    public void showDoctors() {
        System.out.println("\nDoctors consulted by " + name + ":");
        for (Doctor d : doctors) {
            System.out.println("   " + d.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Doctor {
    private String name;
    private ArrayList<Patient> patients;   

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void consult(Patient p) {
        System.out.println("Consultation: Dr. " + name + " is consulting patient " + p.getName());
        p.addDoctor(this);   
        patients.add(p);     
    }
    public void showPatients() {
        System.out.println("\nPatients consulted by Dr. " + name + ":");
        for (Patient p : patients) {
            System.out.println("   " + p.getName());
        }
    }
}
class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void showHospitalDetails() {
        System.out.println("\nHospital: " + hospitalName);

        System.out.println("\nDoctors:");
        for (Doctor d : doctors) {
            System.out.println("   " + d.getName());
        }

        System.out.println("\nPatients:");
        for (Patient p : patients) {
            System.out.println("   " + p.getName());
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Care Hospital");
        Doctor d1 = new Doctor("Anuj Gupta");
        Doctor d2 = new Doctor("Meera Sharma");
        Patient p1 = new Patient("Diksha Verma");
        Patient p2 = new Patient("Riya Singh");
        Patient p3 = new Patient("Aman Kumar");
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);
        hospital.addPatient(p3);
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
        d2.consult(p3);
        hospital.showHospitalDetails();
        d1.showPatients();
        d2.showPatients();
        p1.showDoctors();
        p2.showDoctors();
        p3.showDoctors();
    }
}

