package spaceStation.models.astronauts;

import spaceStation.models.bags.Bag;

import static spaceStation.common.ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
//        this.bag = new ;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0.0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    public void breath() {
        double oxygen = this.getOxygen() - 10.0;

        if (oxygen < 0.0) {
            oxygen = 0.0;
        }
        this.setOxygen(oxygen);
    }

    public boolean canBreath() {
        if (this.getOxygen() > 0.0) {
            return true;
        } else {
            return false;
        }
    }
}
