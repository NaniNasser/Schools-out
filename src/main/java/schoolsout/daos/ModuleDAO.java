package schoolsout.daos;

import schoolsout.models.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ModuleDAO implements IDAO<Module>{
    private EntityManagerFactory emf;

    public ModuleDAO(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public void save(Module module) {
        EntityManager em = getEntityManager(emf);
        em.getTransaction().begin();
        em.persist(module);
        em.getTransaction().commit();
        em.close();
    }
    
    

    @Override
    public Module findById(Object id) {
       EntityManager em = getEntityManager(emf);
        Module module = em.find(Module.class, id);
        em.close();
        return module;
    }

    @Override
    public List<Module> findAll() {
        EntityManager em = getEntityManager(emf);
        TypedQuery<Module> query = em.createQuery("SELECT p FROM module p", Module.class);
        List<Module> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public void update(Module module) {
        EntityManager em = getEntityManager(emf);
        if (module.getId() != null){
            em.getTransaction().begin();
            em.merge(module);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public void remove(Module module) {
        EntityManager em = getEntityManager(emf);
        if (module.getId() != null){
            em.getTransaction().begin();
            em.remove(em.contains(module) ? module : em.merge(module));
            em.flush();
            em.getTransaction().commit();
        }
        em.close();
    }

    }

