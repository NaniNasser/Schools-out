package schoolsout.daos;

import schoolsout.models.Course;
import schoolsout.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements schoolsout.daos.IDAO<Person> {


    @Override
    public void save(Person person) {
        EntityManager em = getEntityManager();
        if (person.getId() == null) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public Person findById(Object id) {
        EntityManager em = getEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    @Override
    public List<Person> findAll() {
        EntityManager em = getEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public void update(Person person) {
        EntityManager em = getEntityManager();
        if (person.getId() != null){
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void remove(Person person) {
        EntityManager em = getEntityManager();
        if (person.getId() != null){
            em.getTransaction().begin();
            em.remove(em.contains(person) ? person : em.merge(person));
            em.flush();
            em.getTransaction().commit();
        }
        em.close();
    }

    public void deactivatePerson(Person person) {
        Person p = findById(person.getId());
        if(p != null){
            Course courseActive = person.getCourseActive();
            List<Course> courseHistory = p.getCourseHistory();
            courseHistory.add(courseActive);
            p.setCourseHistory(courseHistory);
            p.setCourseActive(null);
            update(p);
        }
    }

}
