package sms.model;

import sms.model.enums.Gender;
import sms.util.IDGenerator;

public class Student extends Person {
    private int studentId;
    private Gender gender;
    private String department;
    private double gpa;

    public Student(String fullName, int age, Gender gender, String department, double gpa) {
        super(fullName, age);
        this.studentId = IDGenerator.generateId();
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }

    public Student(Student other) {
        super(other.fullName, other.age);
        this.studentId = other.studentId;
        this.gender = other.gender;
        this.department = other.department;
        this.gpa = other.gpa;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Department: " + department);
        System.out.println("GPA: " + gpa);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%d,%s,%s,%.2f",
                studentId, fullName, age, gender, department, gpa);
    }

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid student data format");
        }

        Student student = new Student(
                parts[1],
                Integer.parseInt(parts[2]),
                Gender.valueOf(parts[3]),
                parts[4],
                Double.parseDouble(parts[5]));
        student.setStudentId(Integer.parseInt(parts[0]));
        return student;
    }
}