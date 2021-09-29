package schoolsout;

import schoolsout.daos.PersonDAO;
import schoolsout.models.Gender;
import schoolsout.models.Person;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

        Person person = new Person();

        Person person0 = new Person("Morty", "Rick", Gender.MALE, person.getCourse());
        Person person1 = new Person("Lord", "Kek", Gender.OTHER, person.getCourse());
        Person person2 = new Person("Nani", "Poonani", Gender.MALE, person.getCourse());
        Person person3 = new Person("Tupac", "Shakur", Gender.MALE, person.getCourse());
        Person person4 = new Person("Biggie", "Smalls", Gender.MALE, person.getCourse());
        Person person5 = new Person("Scarlet", "Johansson", Gender.FEMALE, person.getCourse());
        Person person6 = new Person("I AM ", "GROOT", Gender.OTHER, person.getCourse());
        Person person7 = new Person("Spongebob ", "Squarespace", Gender.OTHER, person.getCourse());
        Person person8 = new Person("Nero ", "GoodBoi", Gender.MALE, person.getCourse());
        Person person9 = new Person("Tosca ", "GoodGirl", Gender.FEMALE, person.getCourse());
        Person person10 = new Person("Saul", "Goodman", Gender.MALE, person.getCourse());



        PersonDAO personDAO = new PersonDAO(emf);
        personDAO.save(person0);
        personDAO.save(person1);
        personDAO.save(person2);
        personDAO.save(person3);
        personDAO.save(person4);
        personDAO.save(person5);
        personDAO.save(person6);
        personDAO.save(person7);
        personDAO.save(person8);
        personDAO.save(person9);
        personDAO.save(person10);

        List<Person> personsFromDB = personDAO.findAll();
        personsFromDB.forEach(System.out::println);


        Person RemovePerson = personsFromDB.get(1);
        personDAO.remove(RemovePerson);
        personDAO.update(RemovePerson);

    }
}