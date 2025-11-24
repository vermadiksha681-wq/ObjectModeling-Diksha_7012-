/* Problem 3: Company and Departments (Composition)
Description: A Company has several Department objects, and each department contains Employee objects. Model this using composition, where deleting a company should also delete all departments and employees.
Tasks:
Define a Company class that contains multiple Department objects.
Define an Employee class within each Department.
Show the composition relationship by ensuring that when a Company object is deleted, all associated Department and Employee objects are also removed.
Goal: Understand composition by implementing a relationship where Department and Employee objects cannot exist without a Company. */

import java.util.ArrayList;
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void showEmployee() {
        System.out.println("      Employee: " + name);
    }
}

class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void showDepartment() {
        System.out.println("   Department: " + deptName);
        for (Employee e : employees) {
            e.showEmployee();
        }
    }
}

class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }
    public Department addDepartment(String deptName) {
        Department d = new Department(deptName);
        departments.add(d);
        return d;
    }
    public void showCompanyStructure() {
        System.out.println("\nCompany: " + companyName);
        for (Department d : departments) {
            d.showDepartment();
        }
    }
    public void deleteCompany() {
        System.out.println("\nDeleting Company: " + companyName + " ...");
        departments.clear();
        System.out.println("All departments and employees removed permanently!");
    }
}

public class CompanyandDepartments {
    public static void main(String[] args) {
        Company c = new Company("TechSoft Pvt. Ltd.");
        Department hr = c.addDepartment("HR Department");
        Department it = c.addDepartment("IT Department");
        hr.addEmployee("Diksha Verma");
        hr.addEmployee("Aditi Sharma");
        it.addEmployee("Anuj Gupta");
        it.addEmployee("Rohan Singh");
        c.showCompanyStructure();
        c.deleteCompany();
        c.showCompanyStructure();
    }
}
