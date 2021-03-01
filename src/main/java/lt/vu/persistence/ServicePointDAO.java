package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.ServicePoint;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ServicePointDAO {

    @PersistenceContext
    @Setter
    private EntityManager em;

    public List<ServicePoint> loadAll() {
        return em.createNamedQuery("ServicePoint.findAll", ServicePoint.class).getResultList();
    }

    public void persist(ServicePoint servicePoint){
        this.em.persist(servicePoint);
    }

    public ServicePoint findOne(Integer id) {
        return em.find(ServicePoint.class, id);
    }
}
