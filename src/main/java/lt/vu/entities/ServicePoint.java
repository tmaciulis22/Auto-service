package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "select s from ServicePoint as s")
})
@Table(name = "SERVICEPOINT")
@Getter @Setter
public class ServicePoint {

    public ServicePoint() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "servicepoint")
    private List<Mechanic> mechanics = new ArrayList<>();
}
