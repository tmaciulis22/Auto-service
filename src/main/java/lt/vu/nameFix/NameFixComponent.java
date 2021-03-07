package lt.vu.nameFix;

import lt.vu.entities.Mechanic;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NameFixComponent implements NameFix {

    public void fixName(Mechanic mechanic) {
        mechanic.setName(mechanic.getName().replaceAll("[^A-Za-z]", ""));
    }

    public void fixName(lt.vu.mybatis.model.Mechanic mechanic) {
        mechanic.setName(mechanic.getName().replaceAll("[^A-Za-z]", ""));
    }
}

