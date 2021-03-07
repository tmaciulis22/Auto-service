package lt.vu.persistence;

import lt.vu.entities.Car;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CarDAO {

    @Setter
    @Inject
    private EntityManager em;

    public List<Car> readAll() {
        return em.createNamedQuery("Car.readAll", Car.class).getResultList();
    }

    public void create(Car car){
        em.persist(car);
    }

    public Car read(Integer id) {
        return em.find(Car.class, id);
    }

    public Car update(Car car) { return em.merge(car); }

    public void delete(Integer id) { em.remove(read(id)); }
}
