package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_INVALID_TYPE;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository = new AstronautRepository();
    private Repository<Planet> planetRepository = new PlanetRepository();
    private Mission mission = new MissionImpl();
    private int exploredPlanetsCount = 0;

    public ControllerImpl() {
    }


    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;
        if ("Biologist".equals(type)) {
            astronaut = new Biologist(astronautName);
        } else if ("Geodesist".equals(type)) {
            astronaut = new Geodesist(astronautName);
        } else if ("Meteorologist".equals(type)) {
            astronaut = new Meteorologist(astronautName);
        }

        if (astronaut == null) {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        } else {
            this.astronautRepository.add(astronaut);
            return String.format(ASTRONAUT_ADDED, type, astronautName);
        }
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        this.planetRepository.add(planet);

        String[] var4 = items;
        int var5 = items.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            String item = var4[var6];
            planet.getItems().add(item);
        }

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = (Astronaut) this.astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            this.astronautRepository.remove(astronaut);
            return String.format(ASTRONAUT_RETIRED, astronautName);
        }
    }

    @Override
    public String explorePlanet(String planetName) {
        int deadAstronauts = 0;

        Planet planet = (Planet) this.planetRepository.findByName(planetName);

        List astronauts = (List) this.astronautRepository.getModels().stream().filter((m) -> {
            return m.getOxygen() > 60.0D;
        }).collect(Collectors.toList());

        if (astronauts.size() == 0) {
            throw new IllegalArgumentException("You need at least one astronaut to explore the planet!");
        }

        String result = String.format(PLANET_EXPLORED, planetName, deadAstronauts);
        return result;
    }


    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s planets were explored!", this.exploredPlanetsCount)).append(System.lineSeparator()).append("Astronauts info:").append(System.lineSeparator());
        Iterator var2 = this.astronautRepository.getModels().iterator();

        while (var2.hasNext()) {
            Astronaut astronaut = (Astronaut) var2.next();
            sb.append(String.format("Name: %s", astronaut.getName())).append(System.lineSeparator()).append(String.format("Oxygen: %.0f", astronaut.getOxygen())).append(System.lineSeparator()).append(String.format("Bag items: %s", String.join(", ", astronaut.getBag().getItems()).equals("") ? "none" : String.join(", ", astronaut.getBag().getItems()))).append(System.lineSeparator());
        }

        String result = sb.toString().trim();
        return result;
    }
}
