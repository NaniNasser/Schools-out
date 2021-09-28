package schoolsout.daos;

import org.hibernate.Session;
import schoolsout.models.Person;


import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.TypedQuery;
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
    public List<Person> findAll() {
        EntityManager em = getEntityManager(emf);
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> list = query.getResultList();
        em.close();
        return list;
    }




    @Override
    public void update(Person person) {
        EntityManager em = getEntityManager(emf);
        if (person.getId() != null){
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        }
        em.close();
    }


    @Override
    public void remove(Person person) {
        EntityManager em = getEntityManager(emf);
        if (person.getId() != null){
            em.getTransaction().begin();
            em.remove(person);
            em.remove(em.contains(person) ? person : em.merge(person));

            em.getTransaction().commit();
        }
        em.close();
    }
}
