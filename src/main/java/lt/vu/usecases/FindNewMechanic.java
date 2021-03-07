package lt.vu.usecases;

import lt.vu.mechanicFinder.MechanicFinder;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
@Named
public class FindNewMechanic implements Serializable {

    @Inject
    private MechanicFinder mechanicFinderComponent;

    private CompletableFuture<String> findingMechanicTask = null;

    public String findNewMechanic() throws InterruptedException {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int serviceId = Integer.parseInt(requestParameters.get("serviceId"));

        findingMechanicTask = mechanicFinderComponent.findNewMechanicAsync();

        return "service?faces-redirect=true&serviceId=" + serviceId;
    }

    public boolean isFindingInProgress() {
        return findingMechanicTask != null && !findingMechanicTask.isDone();
    }

    public String getFindingTaskStatus() throws ExecutionException, InterruptedException {
        if (findingMechanicTask == null) {
            return null;
        } else if (!findingMechanicTask.isDone()) {
            return "Finding new mechanic...";
        }

        return "Mechanic found! Name: " + findingMechanicTask.get();
    }
}
