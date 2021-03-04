package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ServiceDAO {

    @Inject
    @Setter
    private EntityManager em;

    public List<Service> loadAll() {
        return em.createNamedQuery("Service.findAll", Service.class).getResultList();
    }

    public void persist(Service service) { em.persist(service); }

    public Service update(Service service) { return em.merge(service); }

    public void flush() { em.flush(); }

    public Service findOne(Integer id) {
        return em.find(Service.class, id);
    }
}
