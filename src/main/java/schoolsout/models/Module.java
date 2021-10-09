package schoolsout.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Module")
public class Module {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(length = 2000)
    private String description;
    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "module", fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private List<Exam> exams;

    public Module(String name, String description, Course course, List<Exam> exams) {
        this.name = name;
        this.description = description;
        this.course = course;
        this.exams = exams;
    }

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public Module setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Module setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Module setDescription(String description) {
        this.description = description;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Module setCourse(Course course) {
        this.course = course;
        return this;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public Module setExams(List<Exam> exams) {
        this.exams = exams;
        return this;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", course=" + (course != null ? course.getName() : null) +
                ", exams=" + exams +
                '}';
    }
}
