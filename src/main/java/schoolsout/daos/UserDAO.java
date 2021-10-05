package schoolsout.daos;

import schoolsout.models.Module;
import schoolsout.models.Person;
import schoolsout.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO implements IDAO<User>{

    private EntityManagerFactory emf;

    public UserDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(User user) {
        EntityManager em = getEntityManager(emf);
        {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        em.close();
    }

    public User smartSave(User user) {
        EntityManager em = getEntityManager(emf);
        em.getTransaction().begin();
        em.persist(user);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return user;
    }

    @Override
    public User findById(Object id) {
        EntityManager em = getEntityManager(emf);
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        EntityManager em = getEntityManager(emf);
        TypedQuery<User> query = em.createQuery("SELECT p FROM User p", User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public void update(User user) {
        EntityManager em = getEntityManager(emf);
       {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void remove(User user) {
        EntityManager em = getEntityManager(emf);
        {
            em.getTransaction().begin();
            em.remove(em.contains(user) ? user : em.merge(user));
            em.flush();
            em.getTransaction().commit();
        }
        em.close();
    }
}

