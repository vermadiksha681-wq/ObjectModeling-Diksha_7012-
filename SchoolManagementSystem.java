/* Problem 1: School and Students with Courses (Association and Aggregation)
Description: Model a School with multiple Student objects, where each student can enroll in multiple courses, and each course can have multiple students.
Tasks:
Define School, Student, and Course classes.
Model an association between Student and Course to show that students can enroll in multiple courses.
Model an aggregation relationship between School and Student.
Demonstrate how a student can view the courses they are enrolled in and how a course can show its enrolled students.
Goal: Practice association by modeling many-to-many relationships between students and courses.
 */

import java.util.*;

class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void showEnrolledStudents() {
        System.out.println("\nStudents enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("   " + s.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}


class Student {
    private String name;
    private ArrayList<Course> courses;  

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    public void enroll(Course c) {
        courses.add(c);
        c.addStudent(this);   
    }


    public void viewCourses() {
        System.out.println("\nCourses of student " + name + ":");
        for (Course c : courses) {
            System.out.println("   " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

class School {
    private String schoolName;
    private ArrayList<Student> students;  
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void showStudents() {
        System.out.println("\nStudents in " + schoolName + ":");
        for (Student s : students) {
            System.out.println("   " + s.getName());
        }
    }
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        School school = new School("Green Valley Public School");
        Student s1 = new Student("Diksha Verma");
        Student s2 = new Student("Anuj Gupta");
        Student s3 = new Student("Riya Sharma");
        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");
        Course c3 = new Course("English");
        s1.enroll(c1);
        s1.enroll(c2);
        s2.enroll(c1);
        s2.enroll(c3);
        s3.enroll(c2);
        school.showStudents();
        s1.viewCourses();
        s2.viewCourses();
        s3.viewCourses(); 
        c1.showEnrolledStudents();
        c2.showEnrolledStudents();
        c3.showEnrolledStudents();
    }
}
