package Exams.MyExam.spaceStationRecruitment;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpaceStation {
    private String name;
    private int capacity;
    private Map<String, Astronaut> data;
    private int occupantsCount;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
        this.occupantsCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Astronaut astronaut) {
        if (this.capacity > this.occupantsCount) {
            this.data.put(astronaut.getName(), astronaut);
            this.occupantsCount++;
        }

    }

    public boolean remove(String name) {
        if (data.containsKey(name)) {
            data.remove(name);
            return true;
        }
        return false;
    }

    public Astronaut getOldestAstronaut() {
        String oldest = "";
        int age = -1;
        for (Astronaut astronaut : this.data.values()) {
            if (astronaut.getAge() > age) {
                oldest = astronaut.getName();
                age = astronaut.getAge();
            }
        }
        return this.data.get(oldest);
    }

    public Astronaut getAstronaut(String name) {
        return this.data.get(name);
    }

    public String report() {
        StringBuilder stationInfo = new StringBuilder();

        stationInfo.append(String.format("Astronauts working at Space Station %s:", this.getName()));
        stationInfo.append(System.lineSeparator());
        for (Astronaut astronaut : this.data.values()) {
            stationInfo.append(astronaut.toString())
                    .append(System.lineSeparator());
        }
        return stationInfo.toString().trim();
    }
}