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
        @NamedQuery(name = "Service.readAll", query = "select s from Service as s")
})
@Table(name = "SERVICE")
@Getter @Setter
@EqualsAndHashCode(of={"id"})
public class Service {

    public Service() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private Integer version;

    @Size(max = 50)
    @Column
    private String name;

    @OneToMany(mappedBy = "service")
    private List<Mechanic> mechanics = new ArrayList<>();
}