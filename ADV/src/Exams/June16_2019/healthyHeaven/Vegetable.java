package Exams.June16_2019.healthyHeaven;

public class Vegetable {
    private String name;
    private int calories;

    public Vegetable(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return this.name;
    }

    public int getCalories() {
        return this.calories;
    }

    @Override
    public String toString() {
        return String.format(" - %s have %s calories",
                this.getName(),
                this.getCalories());
    }
}
