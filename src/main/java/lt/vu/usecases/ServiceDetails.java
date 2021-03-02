package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Mechanic;
import lt.vu.entities.Service;
import lt.vu.persistence.MechanicDAO;
import lt.vu.persistence.ServiceDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class ServiceDetails {

    @Inject
    private ServiceDAO serviceDAO;

    @Inject
    private MechanicDAO mechanicDAO;

    @Getter @Setter
    private Service service;

    @Getter @Setter
    private Mechanic newMechanic = new Mechanic();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer serviceId = Integer.parseInt(requestParameters.get("serviceId"));
        this.service = serviceDAO.findOne(serviceId);
    }

    @Transactional
    public String addMechanic() {
        this.newMechanic.setService(this.service);
        this.mechanicDAO.persist(newMechanic);
        return "service?faces-redirect=true&serviceId=" + this.service.getId();
    }
}
