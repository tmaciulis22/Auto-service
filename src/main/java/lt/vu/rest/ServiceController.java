package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Service;
import lt.vu.persistence.ServiceDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/service")
public class ServiceController {

    @Inject
    @Getter @Setter
    private ServiceDAO serviceDAO;

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Service> services = serviceDAO.readAll();
        List<ServiceDTO> servicesDTO = services.stream().map(service -> {
           ServiceDTO serviceDTO = new ServiceDTO();
           serviceDTO.setName(service.getName());
           serviceDTO.setId(service.getId());
           return serviceDTO;
        }).collect(Collectors.toList());

        return Response.ok(servicesDTO).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("id") final Integer id) {
        Service service = serviceDAO.read(id);
        if (service == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getId());
        serviceDTO.setName(service.getName());

        return Response.ok(serviceDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ServiceDTO serviceDTO) {
        Service service = new Service();
        service.setName(serviceDTO.getName());
        serviceDAO.create(service);
        serviceDTO.setId(service.getId());

        return Response.ok(serviceDTO).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(ServiceDTO serviceDTO, @QueryParam("id") final Integer id) {
        try {
            Service service = serviceDAO.read(id);

            if (service == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            service.setName(serviceDTO.getName());
            serviceDAO.update(service);

            return Response.ok().build();
        } catch (OptimisticLockException ex) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
