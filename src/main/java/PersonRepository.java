
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Persons;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Component
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Persons> getPersonsByCity(String city){
        return entityManager.createQuery("select p from Persons p where p.city = :city", Persons.class)
                .setParameter("city", city)
                .getResultList();
    }
}
