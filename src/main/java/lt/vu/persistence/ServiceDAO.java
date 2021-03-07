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

    public List<Service> readAll() {
        return em.createNamedQuery("Service.readAll", Service.class).getResultList();
    }

    public void flush() { em.flush(); }

    public void create(Service service){
        this.em.persist(service);
    }

    public Service read(Integer id) {
        return em.find(Service.class, id);
    }

    public Service update(Service service) { return em.merge(service); }

    public void delete(Integer id) { em.remove(read(id)); }
}
