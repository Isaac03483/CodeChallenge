package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Department {
    
    private Map<Student, Integer> studentMarks;

    public Department() {
        this.studentMarks = new HashMap<Student, Integer>();
    }

    public void addStudent(Student student, Integer mark) { // O(1)
        Integer value = this.studentMarks.get(student);
        if(value != null) this.studentMarks.remove(student);
        this.studentMarks.put(student, mark);
    }

    public String showStudents() { // O(n)
        //TODO: LOGIC TO PRINT STUDENTS AND MARKS
        StringBuilder builder = new StringBuilder();

        this.studentMarks.entrySet().forEach(studentMark -> {
            String student = studentMark.getKey() + ": " + studentMark.getValue() + ".";
            System.out.println(student);
            builder.append(student + "\n");
        });
        return builder.toString();
    }

    public Map<Student, Integer> getStudentMarks() {
        return studentMarks;
    }

    
}
