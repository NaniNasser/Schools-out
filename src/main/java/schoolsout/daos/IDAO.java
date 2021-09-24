package schoolsout.daos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface IDAO<T> {

    default EntityManager getEntityManager(EntityManagerFactory emf){
        return emf.createEntityManager();
    }

        void save(T t);
        T findById(Object id);

        List<T> findAll();
        void update(T t);
        void remove(T t);
    }


