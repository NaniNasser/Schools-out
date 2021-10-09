package schoolsout.daos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public interface IDAO<T> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
    default EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

        void save(T t);
        T findById(Object id);

        List<T> findAll();
        void update(T t);
        void remove(T t);
    }


