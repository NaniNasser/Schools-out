package schoolsout.models;

import javax.persistence.*;
import java.time.LocalDate;
import schoolsout.models.Module;

@Entity
public class Exam {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Column(length = 2000)
    private String description;
    private LocalDate date;
    private int weight;
    private int total;

    @ManyToOne
    private Module module;

    public Exam() {}
    public Exam(String name, String description, LocalDate date, int weight, int total, Module module) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.weight = weight;
        this.total = total;
        this.module = module;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public schoolsout.models.Module getModule() {
        return module;
    }

    public void setModule(schoolsout.models.Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", weight=" + weight +
                ", total=" + total +
                ", module=" + (module == null ? null : module.getName()) +
                '}';
    }
}