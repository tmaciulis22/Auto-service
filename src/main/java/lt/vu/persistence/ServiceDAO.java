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

    public void persist(Service service){
        this.em.persist(service);
    }

    public Service findOne(Integer id) {
        return em.find(Service.class, id);
    }
}
