package schoolsout.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    private String login;
    private String passwordHash;
    private boolean active;

    @OneToOne
    private Person person;

    public User(String login, String passwordHash, boolean active, Person person) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.active = active;
        this.person = person;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public schoolsout.models.Person getPerson() {
        return person;
    }

    public void setPerson(schoolsout.models.Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "schoolsout.models.User{" +
                "login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", active=" + active +
                ", person=" + person +
                '}';
    }


}
