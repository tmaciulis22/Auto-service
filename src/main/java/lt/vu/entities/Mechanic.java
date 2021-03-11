package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Mechanic.readAll", query = "select m from Mechanic as m")
})
@Table(name = "MECHANIC")
@Getter @Setter
@EqualsAndHashCode(of={"id"})
public class Mechanic {

    public Mechanic() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="SERVICE_ID")
    private Service service;

    @ManyToMany
    @JoinTable(name="MECHANIC_CAR")
    private List<Car> cars = new ArrayList<>();
}