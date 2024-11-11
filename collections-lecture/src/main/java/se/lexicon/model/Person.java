package se.lexicon.model;

import java.util.Objects;

public class Person implements Comparable<Person> {

    // Fields, Constructor, Getters & Setters, toString

    // Equals & Hashcode
    // CompareTo - (Comparable Interface)

    private int id;
    private String firstName;
    private String lastname;
    private String email;

    public Person(int id, String firstName, String lastname, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastname(), person.getLastname()) && Objects.equals(getEmail(), person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastname(), getEmail());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //Natural ordering
    @Override
    public int compareTo(Person person) {

        if (id > person.getId()){
            return 1;
        }else if (id < person.getId()){
            return -1;
        }

        return 0;
    }
}
