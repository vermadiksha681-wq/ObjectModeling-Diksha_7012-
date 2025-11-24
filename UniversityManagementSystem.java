/* Problem 2: University with Faculties and Departments (Composition and Aggregation)
Description: Create a University with multiple Faculty members and Department objects. Model it so that the University and its Departments are in a composition relationship (deleting a university deletes all departments), and the Faculty members are in an aggregation relationship (faculty can exist outside of any specific department).
Tasks:
Define a University class with Department and Faculty classes.
Demonstrate how deleting a University also deletes its Departments.
Show that Faculty members can exist independently of a Department.
Goal: Understand the differences between composition and aggregation in modeling complex hierarchical relationships. */

import java.util.*;
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void showFaculty() {
        System.out.println("   Faculty: " + name);
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void showDepartment() {
        System.out.println("   Department: " + deptName);
    }

    public String getDeptName() {
        return deptName;
    }
}

class University {
    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> facultyMembers;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }
    public Department addDepartment(String deptName) {
        Department d = new Department(deptName);
        departments.add(d);
        return d;
    }

    public void addFaculty(Faculty f) {
        facultyMembers.add(f);
    }
    public void showUniversityDetails() {
        System.out.println("\nUniversity: " + universityName);

        System.out.println("\nDepartments (Composition):");
        for (Department d : departments) {
            d.showDepartment();
        }

        System.out.println("\nFaculty Members (Aggregation):");
        for (Faculty f : facultyMembers) {
            f.showFaculty();
        }
    }
    public void deleteUniversity() {
        System.out.println("\nDeleting University: " + universityName + " ...");
        departments.clear();
        System.out.println("Departments deleted due to Composition.");
        System.out.println("Faculty still exist independently (Aggregation).");
    }

    public ArrayList<Faculty> getFacultyList() {
        return facultyMembers;
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        University uni = new University("Delhi Technological University");
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical Engineering");
        uni.addDepartment("Electronics Engineering");
        Faculty f1 = new Faculty("Dr. Diksha Verma");
        Faculty f2 = new Faculty("Dr. Anuj Gupta");
        Faculty f3 = new Faculty("Dr. Riya Sharma");
        uni.addFaculty(f1);
        uni.addFaculty(f2);
        uni.addFaculty(f3);
        uni.showUniversityDetails();
        uni.deleteUniversity();
        System.out.println("\nFaculty still existing independently:");
        for (Faculty f : uni.getFacultyList()) {
            f.showFaculty();
        }
    }
}
