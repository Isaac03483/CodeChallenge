package org.example;


import org.example.models.Department;
import org.example.models.Student;

/**
 * Hello world!
 *
 */
public class App {

    private Department department;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;

    public static void main( String[] args ) {
        App app = new App();
        app.department = new Department();
        app.student1 = new Student("name1", "lastname1");
        app.student2 = new Student("name2", "lastname2");
        app.student3 = new Student("name3", "lastname3");
        app.student4 = new Student("name4", "lastname4");
        app.department.addStudent(app.student1, 10);
        app.department.addStudent(app.student2, 20);
        app.department.addStudent(app.student3, 30);
        app.department.addStudent(app.student4, 40);

        app.department.showStudents();
    }
}