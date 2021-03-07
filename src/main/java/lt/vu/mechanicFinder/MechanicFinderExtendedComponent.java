package lt.vu.mechanicFinder;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Alternative
@Specializes
@SessionScoped
public class MechanicFinderExtendedComponent extends MechanicFinderComponent {

    private final List<String> mockExternalData = new ArrayList<String>() {
        {
            add("Max");
            add("Aleksey");
            add("George");
            add("Thomas");
            add("Bruce");
            add("Ivan");
        }
    };

    public CompletableFuture<String> findNewMechanicAsync() throws InterruptedException {
        Random rand = new Random();
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(100);
            int index = rand.nextInt(mockExternalData.size());
            completableFuture.complete(mockExternalData.get(index));
            return null;
        });

        return completableFuture;
    }
}
