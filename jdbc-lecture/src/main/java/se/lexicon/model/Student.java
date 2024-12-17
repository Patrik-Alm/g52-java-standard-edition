package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private LocalDate createDate;

    public Student(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Student(int studentId, String firstName, String lastName, int age, String email, LocalDate createDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.createDate = createDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getStudentId() == student.getStudentId() && getAge() == student.getAge() && Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getEmail(), student.getEmail()) && Objects.equals(getCreateDate(), student.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getFirstName(), getLastName(), getAge(), getEmail(), getCreateDate());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
