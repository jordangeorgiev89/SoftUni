package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> planets = new LinkedHashMap();

    public PlanetRepository() {
    }

    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets.values());
    }

    public void add(Planet model) {
        this.planets.put(model.getName(), model);
    }

    public boolean remove(Planet model) {
        return this.planets.remove(model.getName(), model);
    }

    public Planet findByName(String name) {
        return (Planet) this.planets.get(name);
    }
}
