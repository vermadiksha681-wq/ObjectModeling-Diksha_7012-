/* Problem 4: E-commerce Platform with Orders, Customers, and Products
Description: Design an e-commerce platform with Order, Customer, and Product classes. Model relationships where a Customer places an Order, and each Order contains multiple Product objects.
Goal: Show communication and object relationships by designing a system where customers communicate through orders, and orders aggregate products.
 */


import java.util.*;

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        System.out.println("Doctor " + name + " is consulting Patient " + p.name);
        patients.add(p);
        p.doctors.add(this);
    }
}

class Patient {
    String name;
    List<Doctor> doctors = new ArrayList<>();

    Patient(String name) {
        this.name = name;
    }
}

class Hospital {
    String name;
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();

    Hospital(String name) {
        this.name = name;
    }

    void addDoctor(Doctor d) { doctors.add(d); }
    void addPatient(Patient p) { patients.add(p); }
}

public class Ecommerce {
    public static void main(String[] args) {

        Hospital h = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dr. Singh");
        Doctor d2 = new Doctor("Dr. Mehta");

        Patient p1 = new Patient("Aman");
        Patient p2 = new Patient("Kamal");

        h.addDoctor(d1);
        h.addDoctor(d2);

        h.addPatient(p1);
        h.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        System.out.println("\nPatients of Dr. Singh:");
        for (Patient p : d1.patients) System.out.println(p.name);

        System.out.println("\nDoctors seen by Aman:");
        for (Doctor d : p1.doctors) System.out.println(d.name);
    }
}

