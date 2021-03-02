package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.NameFixComponent;
import lt.vu.mybatis.dao.MechanicMapper;
import lt.vu.mybatis.dao.ServiceMapper;
import lt.vu.mybatis.model.Mechanic;
import lt.vu.mybatis.model.Service;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Model
public class ServiceDetailsMyBatis {

    @Inject
    private ServiceMapper serviceMapper;

    @Inject
    private MechanicMapper mechanicMapper;

    @Getter @Setter
    private Service service;

    @Getter @Setter
    private List<Mechanic> mechanicList;

    @Getter @Setter
    private Mechanic newMechanic = new Mechanic();

    @Inject
    private NameFixComponent nameFixComponent;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer serviceId = Integer.parseInt(requestParameters.get("serviceId"));
        this.service = serviceMapper.selectByPrimaryKey(serviceId);
        this.mechanicList = mechanicMapper
                .selectAll()
                .stream()
                .filter(mechanic -> mechanic.getServiceId().equals(this.service.getId()))
                .collect(Collectors.toList());
    }

    @Transactional
    public String addMechanic() {
        nameFixComponent.fixName(newMechanic);
        this.newMechanic.setServiceId(this.service.getId());
        this.mechanicMapper.insert(newMechanic);
        return "service?faces-redirect=true&serviceId=" + this.service.getId();
    }
}
