package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Car.readAll", query = "select c from Car as c")
})
@Table(name = "CAR")
@Getter @Setter
@EqualsAndHashCode(of={"id"})
public class Car {

    public Car() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BRAND")
    private String make;

    @Column
    private String model;

    @ManyToMany
    public List<Mechanic> mechanics = new ArrayList<>();
}
