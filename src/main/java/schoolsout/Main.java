package schoolsout;

import schoolsout.daos.PersonDAO;
import schoolsout.models.Gender;
import schoolsout.models.Person;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

        Person person = new Person();

        Person person0 = new Person(01,"Nasser", "Faqiri",Gender.MALE, person.getCourse());
        Person person1 = new Person(02,"Nani", "Poonani",Gender.MALE, person.getCourse());
        Person person2 = new Person(03,"Tupac", "Shakur",Gender.MALE, person.getCourse());
        Person person3 = new Person(04,"Biggie", "Smalls",Gender.MALE, person.getCourse());







    }
}
