package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.nameFix.NameFix;
import lt.vu.entities.Mechanic;
import lt.vu.entities.Service;
import lt.vu.persistence.MechanicDAO;
import lt.vu.persistence.ServiceDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class ServiceDetails {

    @Inject
    private ServiceDAO serviceDAO;

    @Inject
    private MechanicDAO mechanicDAO;

    @Getter
    @Setter
    private Service service;

    @Getter @Setter
    private Mechanic newMechanic = new Mechanic();

    @Inject
    private NameFix nameFixComponent;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer serviceId = Integer.parseInt(requestParameters.get("serviceId"));
        service = serviceDAO.findOne(serviceId);
    }

    @Transactional
    public String addMechanic() {
        nameFixComponent.fixName(newMechanic);
        newMechanic.setService(service);
        mechanicDAO.persist(newMechanic);
        return "service?faces-redirect=true&serviceId=" + service.getId();
    }

    @Transactional
    public String updateServiceName(Boolean sleep) {
        serviceDAO.update(this.service);
        if (sleep) {
            try {
                Thread.sleep(5000);
                serviceDAO.flush();
            } catch (OptimisticLockException e) {
                return "service?faces-redirect=true&serviceId=" + service.getId() + "&error=optimistic-lock-exception";
            } catch (Exception ignored) { }
        }
        return "index?faces-redirect=true";
    }
}
