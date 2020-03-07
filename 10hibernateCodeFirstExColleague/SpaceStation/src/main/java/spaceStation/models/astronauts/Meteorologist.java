package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    private static final double METEOROLOGIST_OXYGEN = 90.0;

    public Meteorologist(String name) {
        super(name, METEOROLOGIST_OXYGEN);
    }
}
