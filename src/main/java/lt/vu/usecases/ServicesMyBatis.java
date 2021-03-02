package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.ServiceMapper;
import lt.vu.mybatis.model.Service;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ServicesMyBatis {
    @Inject
    private ServiceMapper serviceMapper;

    @Getter
    private List<Service> serviceList;

    @Getter @Setter
    private Service newService = new Service();

    @PostConstruct
    public void init() {
        this.serviceList = serviceMapper.selectAll();
    }

    @Transactional
    public String addService() {
        serviceMapper.insert(newService);
        return "/mybatis/services?faces-redirect=true";
    }
}
