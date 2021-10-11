package schoolsout.daos;

import schoolsout.models.Grade;
import schoolsout.models.Grade;
import schoolsout.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO implements IDAO<Grade> {


    @Override
    public void save(Grade grade) {
        EntityManager em = getEntityManager();
        if (grade.getId() == null) {
            em.getTransaction().begin();
            em.persist(grade);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public Grade findById(Object id) {
        EntityManager em = getEntityManager();
        Grade grade = em.find(Grade.class, id);
        em.close();
        return grade;
    }

    @Override
    public List<Grade> findAll() {
        EntityManager em = getEntityManager();
        TypedQuery<Grade> query = em.createQuery("SELECT p FROM Grade p", Grade.class);
        List<Grade> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public void update(Grade grade) {
        EntityManager em = getEntityManager();
        if (grade.getId() != null) {
            em.getTransaction().begin();
            em.merge(grade);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void remove(Grade grade) {
        EntityManager em = getEntityManager();
        if (grade.getId() != null) {
            em.getTransaction().begin();
            em.remove(em.contains(grade) ? grade : em.merge(grade));
            em.flush();
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<Grade> findByPerson(Person person) {
        EntityManager em = getEntityManager();
        TypedQuery<Grade> query = em.createQuery("SELECT g FROM Grade g WHERE g.person.id = :id", Grade.class);
        query.setParameter("id", person.getId());
        List<Grade> list = query.getResultList();
        em.close();
        return list;
    }


   /* public double averageGrade(Person person) {

        EntityManager em = getEntityManager();
        TypedQuery<Grade> query = em.createQuery("SELECT g FROM Grade g WHERE g.person.id = :id", Grade.class);
        query.setParameter("id", person.getId());
        List<Grade> list = query.getResultList();
        int i = 0;
        double averageGrade = 0;
        while (i < list.size()) {
           averageGrade = averageGrade + list.get(i);
            i++;
        }
        em.close();
        return average;
    }*/
}

