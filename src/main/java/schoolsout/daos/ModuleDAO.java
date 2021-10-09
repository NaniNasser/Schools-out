package schoolsout.daos;

import schoolsout.models.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ModuleDAO implements IDAO<Module>{

    @Override
    public void save(Module module) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(module);
        em.getTransaction().commit();
        em.close();
    }

    public Module smartSave(Module module) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(module);
        em.flush();
        em.getTransaction().commit();
        em.close();
        return module;
    }

    @Override
    public Module findById(Object id) {
       EntityManager em = getEntityManager();
        Module module = em.find(Module.class, id);
        em.close();
        return module;
    }

    @Override
    public List<Module> findAll() {
        EntityManager em = getEntityManager();
        TypedQuery<Module> query = em.createQuery("SELECT p FROM Module p", Module.class);
        List<Module> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public void update(Module module) {
        EntityManager em = getEntityManager();
        if (module.getId() != null){
            em.getTransaction().begin();
            em.merge(module);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void remove(Module module) {
        EntityManager em = getEntityManager();
        if (module.getId() != null){
            em.getTransaction().begin();
            em.remove(em.contains(module) ? module : em.merge(module));
            em.flush();
            em.getTransaction().commit();
        }
        em.close();
    }

    }

