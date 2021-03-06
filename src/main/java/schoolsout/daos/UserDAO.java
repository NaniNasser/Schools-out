package schoolsout.daos;

import schoolsout.models.Module;
import schoolsout.models.Person;
import schoolsout.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO implements IDAO<User> {

    @Override
    public void save(User user) {
        if (findById(user.getLogin()) == null) {
            EntityManager em = getEntityManager();

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

            em.close();
        } else System.out.println("User does not exist");
    }


    public User smartSave(User user) {
        if (findById(user.getLogin()) == null) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.flush();
            em.getTransaction().commit();
            em.close();

        }
        return user;
    }



    @Override
    public User findById(Object id) {
            EntityManager em = getEntityManager();
            User user = em.find(User.class, id);
            em.close();
            return user;
        }


    @Override
    public List<User> findAll() {
        EntityManager em = getEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT p FROM User p", User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public void update(User user) {
        if (findById(user.getLogin()) != null){
            EntityManager em = getEntityManager();
            em.persist(em.contains(user) ? user : em.merge(user));
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();

            em.close();
        }
    }

    @Override
    public void remove(User user) {
        if (findById(user.getLogin()) != null) {
            EntityManager em = getEntityManager();

            em.getTransaction().begin();
            em.remove(em.contains(user) ? user : em.merge(user));
            em.flush();
            em.getTransaction().commit();

        em.close();
        }
    }
}

