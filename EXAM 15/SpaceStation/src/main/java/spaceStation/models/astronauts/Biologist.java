package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double BIOLOGIST_OXYGEN = 70.0;

    public Biologist(String name) {
        super(name, BIOLOGIST_OXYGEN);
    }

    @Override
    public void breath() {
        double oxygen = this.getOxygen() - 5.0;

        if (oxygen < 0.0) {
            oxygen = 0.0;
        }
        this.setOxygen(oxygen);
    }
}
