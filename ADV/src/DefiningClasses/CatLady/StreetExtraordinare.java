package DefiningClasses.CatLady;

public class StreetExtraordinare extends Cat {

    public StreetExtraordinare(String name, double skillValue) {
        super(name, skillValue);
    }

    @Override
    public String toString() {
        return "StreetExtraordinare " + super.toString();

    }
}
