package lt.vu.mechanicFinder;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@SessionScoped
public class MechanicFinderComponent implements Serializable, MechanicFinder {

    private final List<String> mockExternalData = new ArrayList<String>() {
        {
            add("Arūnas");
            add("Gintaras");
            add("Audrius");
            add("Giedrius");
            add("Linas");
            add("Aidas");
            add("Rytis");
            add("Rimvydas");
            add("Aleksandras");
        }
    };

    public CompletableFuture<String> findNewMechanicAsync() throws InterruptedException {
        Random rand = new Random();
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(4000);
            int index = rand.nextInt(mockExternalData.size());
            completableFuture.complete(mockExternalData.get(index));
            return null;
        });

        return completableFuture;
    }
}
