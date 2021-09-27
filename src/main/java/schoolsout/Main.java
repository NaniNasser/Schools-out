package schoolsout;

import schoolsout.daos.PersonDAO;
import schoolsout.models.Course;
import schoolsout.models.Gender;
import schoolsout.models.Person;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

        Person person = new Person();

        Person person1 = new Person("Nasser", "Faqiri",Gender.MALE, person.getCourse());
        Person person2 = new Person("Nani", "Poonani",Gender.MALE, person.getCourse());
        Person person3 = new Person("Tupac", "Shakur",Gender.MALE, person.getCourse());
        Person person4 = new Person("Biggie", "Smalls",Gender.MALE, person.getCourse());
        Person person5 = new Person("Scarlet", "Johansson",Gender.FEMALE, person.getCourse());


        PersonDAO personDAO = new PersonDAO(emf);
        personDAO.save(person1);
        personDAO.save(person2);
        personDAO.save(person3);
        personDAO.save(person4);
        personDAO.save(person5);

        List<Person> personsFromDB = personDAO.findAll();
        personsFromDB.forEach(System.out::println);

        Person person1FromDB = personsFromDB.get(0);
        person1FromDB.setFamilyName("testFamilyName");
        person1FromDB.setFirstName("testFirstName");
        personDAO.update(person1FromDB);

        Person RemovePerson = personsFromDB.get(2);
        personDAO.remove(RemovePerson);

        Person byId = personDAO.findById(3);
        System.out.println(byId);

    }
}
