package lt.vu.namefix;

import lt.vu.entities.Mechanic;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Alternative
@Named
@RequestScoped
public class NameFixComponentAlt implements NameFix {

    public void fixName(Mechanic mechanic) {
        String fixedName = mechanic.getName().replaceAll("[^A-Za-z]", "");
        String firstCapitalized = fixedName.substring(0, 1).toUpperCase() + fixedName.substring(1);
        mechanic.setName(firstCapitalized);
    }

    @Override
    public void fixName(lt.vu.mybatis.model.Mechanic mechanic) {
        String fixedName = mechanic.getName().replaceAll("[^A-Za-z]", "");
        String firstCapitalized = fixedName.substring(0, 1).toUpperCase() + fixedName.substring(1);
        mechanic.setName(firstCapitalized);    }
}
