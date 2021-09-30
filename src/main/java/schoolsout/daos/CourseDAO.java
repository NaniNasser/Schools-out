package schoolsout.daos;

import schoolsout.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDAO implements schoolsout.daos.IDAO<Course> {

    private EntityManagerFactory emf;

    public CourseDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Course course) {
        EntityManager em = getEntityManager(emf);
        if (course.getId() == null) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }
        em.close();
    }



    @Override
    public Course findById(Object id) {
        EntityManager em = getEntityManager(emf);
        Course course = em.find(Course.class, id);
        em.close();
        return course;
    }

    @Override
    public List<Course> findAll() {
        EntityManager em = getEntityManager(emf);
        TypedQuery<Course> query = em.createQuery("SELECT p FROM Course p", Course.class);
        List<Course> list = query.getResultList();
        em.close();
        return list;
    }




    @Override
    public void update(Course course) {
        EntityManager em = getEntityManager(emf);
        if (course.getId() != null){
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        }
        em.close();
    }


    @Override
    public void remove(Course course) {
        EntityManager em = getEntityManager(emf);
        if (course.getId() != null){
            em.getTransaction().begin();
            em.remove(em.contains(course) ? course : em.merge(course));
            em.flush();
            em.getTransaction().commit();
        }
        em.close();
    }
}
