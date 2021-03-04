package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Service.findAll", query = "select s from Service as s")
})
@Table(name = "SERVICE")
@Getter @Setter
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