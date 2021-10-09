package schoolsout.models;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    private String login;
    private String passwordHash;
    private boolean active;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Person person;

    public User(String login, String passwordHash, boolean active, Person person) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.active = active;
        this.person = person;
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public User setPerson(schoolsout.models.Person person) {
        this.person = person;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", active=" + active +
                ", person=" + person +
                '}';
    }
}
