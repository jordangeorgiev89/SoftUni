package DefiningClasses.SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double consumption;
    private int distanceTravelled;

    public Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distanceTravelled = 0;
    }

    public boolean drive(int distance) {
        double fuelNeeded = distance * this.consumption;

        if (this.fuel >= fuelNeeded) {
            this.fuel -= fuelNeeded;
            this.distanceTravelled += distance;
            return true;
        }
        return false;
    }

    public String getInfo() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTravelled);
    }
}
