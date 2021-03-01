package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CarDAO {

    @Setter
    @Inject
    private EntityManager em;

    public List<Car> loadAll() {
        return em.createNamedQuery("Car.findAll", Car.class).getResultList();
    }

    public void persist(Car car){
        this.em.persist(car);
    }

    public Car findOne(Integer id) {
        return em.find(Car.class, id);
    }
}
