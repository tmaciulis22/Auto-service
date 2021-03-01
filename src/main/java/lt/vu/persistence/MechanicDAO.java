package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Mechanic;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class MechanicDAO {

    @PersistenceContext
    @Setter
    private EntityManager em;

    public List<Mechanic> loadAll() {
        return em.createNamedQuery("Mechanic.findAll", Mechanic.class).getResultList();
    }

    public void persist(Mechanic mechanic){
        this.em.persist(mechanic);
    }

    public Mechanic findOne(Integer id) {
        return em.find(Mechanic.class, id);
    }
}
