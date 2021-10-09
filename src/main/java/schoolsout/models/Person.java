package schoolsout.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Persons")

public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String familyName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Course courseActive;

    @ManyToMany
    List<Course> courseHistory = new ArrayList<>();

    public Person() {

    }

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Person setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Course getCourseActive() {
        return courseActive;
    }

    public Person setCourseActive(Course courseActive) {
        this.courseActive = courseActive;
        return this;
    }

    public List<Course> getCourseHistory() {
        return courseHistory;
    }

    public Person setCourseHistory(List<Course> courseHistory) {
        this.courseHistory = courseHistory;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", gender=" + gender +
                ", courseActive=" + courseActive +
                ", courseHistory=" + courseHistory +
                '}';
    }
}