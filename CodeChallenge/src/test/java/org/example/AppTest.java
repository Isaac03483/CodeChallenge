package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.example.models.Department;
import org.example.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AppTest {

    private Department department;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;

    @BeforeEach
    void setUp() {
        department = new Department();
        student1 = new Student("name1", "lastname1");
        student2 = new Student("name2", "lastname2");
        student3 = new Student("name3", "lastname3");
        student4 = new Student("name4", "lastname4");
    }

    @Test
    void shouldAddStudents() {
        // Given setUp

        // When
        department.addStudent(student1, 10);
        department.addStudent(student2, 20);
        department.addStudent(student3, 30);
        department.addStudent(student4, 40);

        // Then
        Map<Student, Integer> expected = new HashMap<>();
        expected.put(student1, 10);
        expected.put(student2, 20);
        expected.put(student3, 30);
        expected.put(student4, 40);

        var actual = department.getStudentMarks();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReplaceStudents() {
        // Given setUp

        // When
        department.addStudent(student1, 10);
        student2.setLastname("lastname1");
        department.addStudent(student2, 20);

        department.addStudent(student3, 30);
        student4.setLastname("lastname3");
        department.addStudent(student4, 40);


        // Then
        Map<Student, Integer> expected = new HashMap<>();
        expected.put(student2, 20);
        expected.put(student4, 40);

        var actual = department.getStudentMarks();

        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintStudents() {
        // Given setUp

        // When
        department.addStudent(student1, 10);
        department.addStudent(student2, 20);
        department.addStudent(student3, 30);
        department.addStudent(student4, 40);

        String expected = "name1 lastname1: 10.\n" +
        "name4 lastname4: 40.\n" +
        "name3 lastname3: 30.\n" +
        "name2 lastname2: 20.\n";

        String actual = department.showStudents();
        // Then
        assertEquals(expected, actual);
    }




}
