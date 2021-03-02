package lt.vu.usecases;

import lt.vu.entities.Service;
import lt.vu.persistence.ServiceDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Services {

    @Inject
    private ServiceDAO serviceDAO;

    @Getter @Setter
    private Service newService = new Service();

    @Getter
    private List<Service> serviceList;

    @PostConstruct
    public void init() {
        fetchAllServices();
    }

    @Transactional
    public String addService() {
        this.serviceDAO.persist(newService);
        return "index?faces-redirect=true";
    }

    private void fetchAllServices() {
        this.serviceList = serviceDAO.loadAll();
    }
}
