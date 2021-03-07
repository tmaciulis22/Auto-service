package lt.vu.persistence;

import lt.vu.entities.Mechanic;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class MechanicDAO {

    @Setter
    @Inject
    private EntityManager em;

    public List<Mechanic> readAll() {
        return em.createNamedQuery("Mechanic.readAll", Mechanic.class).getResultList();
    }

    public void create(Mechanic mechanic){
        em.persist(mechanic);
    }

    public Mechanic read(Integer id) {
        return em.find(Mechanic.class, id);
    }

    public Mechanic update(Mechanic mechanic) { return em.merge(mechanic); }

    public void delete(Integer id) { em.remove(read(id)); }
}