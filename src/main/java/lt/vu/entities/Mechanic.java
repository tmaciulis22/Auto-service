package lt.vu.entities;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return id.equals(mechanic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}