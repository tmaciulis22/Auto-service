package lt.vu.decorator;

import lt.vu.entities.Mechanic;
import lt.vu.nameFix.NameFix;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class NameFixDecorator implements NameFix {

    @Inject @Delegate @Any
    NameFix nameFix;

    public void fixName(Mechanic mechanic) {
        nameFix.fixName(mechanic);
        String firstCapitalized = mechanic.getName().substring(0, 1).toUpperCase() + mechanic.getName().substring(1);
        mechanic.setName(firstCapitalized);
    }

    public void fixName(lt.vu.mybatis.model.Mechanic mechanic) {
        nameFix.fixName(mechanic);
        String firstCapitalized = mechanic.getName().substring(0, 1).toUpperCase() + mechanic.getName().substring(1);
        mechanic.setName(firstCapitalized);
    }
}
