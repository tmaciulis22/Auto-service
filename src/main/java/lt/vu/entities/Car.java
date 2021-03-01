package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Car.findAll", query = "select c from Car as c")
})
@Table(name = "CAR")
@Getter @Setter
public class Car {

    public Car() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String make;

    private String model;

    @ManyToMany(mappedBy="mechanics")
    public List<Mechanic> mechanics = new ArrayList<>();
}
