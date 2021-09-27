package schoolsout.daos;

import schoolsout.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PersonDAO implements IDAO<Person> {

    private EntityManagerFactory emf;

    public PersonDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public void save(Person person) {
        EntityManager em = getEntityManager(emf);
        if (person.getId() == null) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public Person findById(Object id) {
        EntityManager em = getEntityManager(emf);
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    @Override
    public  List<Person> findAll(Person person); {
        EntityManager em = getEntityManager(emf);
        Person person = em.find(Person.class, List<Person> findAll();


        }


    @Override
    public void update(Person person) {
        EntityManager em = getEntityManager(emf);
        if (person.getId() != null){
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
        em.close();
    }


    @Override
    public void remove(Person person) {

    }
}