package schoolsout.daos;

import schoolsout.models.Course;
import schoolsout.models.Exam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ExamDAO implements IDAO<Exam> {

    private EntityManagerFactory emf;

    public ExamDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Exam exam) {
        EntityManager em = getEntityManager(emf);
        if (exam.getId() == null) {
            em.getTransaction().begin();
            em.persist(exam);
            em.getTransaction().commit();
        }
        em.close();
    }



    @Override
    public Exam findById(Object id) {
        EntityManager em = getEntityManager(emf);
        Exam exam = em.find(Exam.class, id);
        em.close();
        return exam;
    }

    @Override
    public List<Exam> findAll() {
        EntityManager em = getEntityManager(emf);
        TypedQuery<Exam> query = em.createQuery("SELECT p FROM Exam p", Exam.class);
        List<Exam> list = query.getResultList();
        em.close();
        return list;
    }




    @Override
    public void update(Exam exam) {
        EntityManager em = getEntityManager(emf);
        if (exam.getId() != null){
            em.getTransaction().begin();
            em.merge(exam);
            em.getTransaction().commit();
        }
        em.close();
    }


    @Override
    public void remove(Exam exam) {
        EntityManager em = getEntityManager(emf);
        if (exam.getId() != null){
            em.getTransaction().begin();
            em.remove(em.contains(exam) ? exam : em.merge(exam));
            em.flush();
            em.getTransaction().commit();
        }
        em.close();
    }
}



