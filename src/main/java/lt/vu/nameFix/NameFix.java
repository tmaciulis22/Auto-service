package lt.vu.nameFix;

import lt.vu.entities.Mechanic;

public interface NameFix {
    void fixName(Mechanic mechanic);

    void fixName(lt.vu.mybatis.model.Mechanic mechanic);
}