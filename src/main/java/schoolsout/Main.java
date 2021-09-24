package schoolsout;

import schoolsout.daos.PersonDAO;
import schoolsout.models.Gender;
import schoolsout.models.Person;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

        Person person = new Person();

        Person person0 = new Person(00,"Nasser", "Faqiri",Gender.MALE, person.getCourse());
        Person person1 = new Person(01,"Nani", "Poonani",Gender.MALE, person.getCourse());
        Person person2 = new Person(02,"test", "test2",Gender.MALE, person.getCourse());
        Person person3 = new Person(03,"test3", "test4",Gender.MALE, person.getCourse());

        PersonDAO personDAO = new PersonDAO();
        personDAO.save(person0);
        personDAO.save(person1);
        personDAO.save(person2);
        personDAO.save(person3);




    }
}
