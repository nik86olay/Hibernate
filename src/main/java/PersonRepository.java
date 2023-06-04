import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Persons;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Persons> getPersonsByCity(String city){
        Persons persons =Persons.builder().name("Oleg").surname("Pavlovich").age(8).city("Moscow").phone_number("999-08").build();
        Persons persons1 =Persons.builder().name("Vladimer").surname("Petrov").age(8).city("Orel").phone_number("789-08").build();
        entityManager.persist(persons);
        entityManager.persist(persons1);
        return entityManager.createQuery("select p from Persons p where p.city = :city", Persons.class)
                .setParameter("city", city)
                .getResultList();
    }
}
