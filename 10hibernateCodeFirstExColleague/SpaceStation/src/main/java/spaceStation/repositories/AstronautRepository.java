package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> astronauts = new LinkedHashMap();

    public AstronautRepository() {
    }

    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    public void add(Astronaut model) {
        this.astronauts.put(model.getName(), model);
    }

    public boolean remove(Astronaut model) {
        return this.astronauts.remove(model.getName(), model);
    }

    public Astronaut findByName(String name) {
        return (Astronaut) this.astronauts.get(name);
    }
}
