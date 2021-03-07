package lt.vu.mechanicFinder;

import java.util.concurrent.CompletableFuture;

public interface MechanicFinder {

    CompletableFuture<String> findNewMechanicAsync() throws InterruptedException;
}
