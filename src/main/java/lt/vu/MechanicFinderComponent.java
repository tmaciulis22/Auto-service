package lt.vu;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class MechanicFinderComponent implements Serializable {

    private final List<String> possibleMechanicNames = new ArrayList<String>() {
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

    public String findNewMechanic() {
        Random rand = new Random();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int index = rand.nextInt(possibleMechanicNames.size());

        return possibleMechanicNames.get(index);
    }
}
