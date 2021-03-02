package lt.vu;

import lt.vu.entities.Mechanic;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class NameFixComponent {

    public void fixName(Mechanic mechanic) {
        mechanic.setName(mechanic.getName().replaceAll("[^A-Za-z]", ""));
    }
}
