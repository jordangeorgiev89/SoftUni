package Exams.February24_2019.heroRepository;

public class Item {
    private int strength;
    private int agility;
    private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public String toString() {
        StringBuilder br = new StringBuilder();

        br.append("Item:")
                .append(System.lineSeparator())
                .append(String.format(" * Strength: %d", this.getStrength()))
                .append(System.lineSeparator())
                .append(String.format(" * Agility: %d", this.getAgility()))
                .append(System.lineSeparator())
                .append(String.format(" * Intelligence: %d", this.getIntelligence()));

        return br.toString().trim();
    }
}
