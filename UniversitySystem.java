/* University Management System
Description: Model a university system with Student, Professor, and Course classes. 
Students enroll in courses, and professors teach courses. 
Ensure students and professors can communicate through methods like enrollCourse() and assignProfessor().
Goal: Use association and aggregation to create a university system that emphasizes relationships 
and interactions among students, professors, and courses.*/

import java.util.ArrayList;
import java.util.List;

class Students {
    private String studentName;
    private List<Courses> enrolledCourses;

    public Students(String studentName) {
        this.studentName = studentName;
        enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Courses c) {
        enrolledCourses.add(c);
        System.out.println(studentName + " enrolled in " + c.getCourseName());
    }

    public void showEnrolledCourses() {
        System.out.println("\nCourses enrolled by " + studentName + ":");
        for (Courses c : enrolledCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

class Professor {
    private String professorName;

    public Professor(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorName() {
        return professorName;
    }
}

class Courses {
    private String courseName;
    private Professor assignedProfessor;

    public Courses(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor p) {
        assignedProfessor = p;
        System.out.println(p.getProfessorName() + " assigned to teach " + courseName);
    }

    public void showCourseInfo() {
        System.out.println("\nCourse: " + courseName);
        if (assignedProfessor != null)
            System.out.println("Taught by: " + assignedProfessor.getProfessorName());
        else
            System.out.println("No professor assigned yet");
    }
}

public class UniversitySystem {
    public static void main(String[] args) {

        Students s1 = new Students("Aarav Mehta");
        Students s2 = new Students("Sara Khan");

        Professor p1 = new Professor("Dr. Ramesh Verma");
        Professor p2 = new Professor("Prof. Neha Sharma");

        Courses c1 = new Courses("Data Structures");
        Courses c2 = new Courses("Operating Systems");
        Courses c3 = new Courses("Machine Learning");

        c1.assignProfessor(p1);
        c2.assignProfessor(p1);
        c3.assignProfessor(p2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c3);

        s2.enrollCourse(c2);
        s2.enrollCourse(c3);

        s1.showEnrolledCourses();
        s2.showEnrolledCourses();

        c1.showCourseInfo();
        c2.showCourseInfo();
        c3.showCourseInfo();
    }
}
