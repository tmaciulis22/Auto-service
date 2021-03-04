package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Mechanic.findAll", query = "select m from Mechanic as m")
})
@Table(name = "MECHANIC")
@Getter @Setter
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
    @JoinTable(name="CAR")
    private List<Car> cars = new ArrayList<>();
}