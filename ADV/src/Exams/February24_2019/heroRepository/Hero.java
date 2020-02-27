package Exams.February24_2019.heroRepository;

public class Hero {
    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public Item getItem() {
        return this.item;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder
                .append(String.format("Hero: %s - %d", this.name, this.level))
                .append(System.lineSeparator())
                .append(String.format(" * Strength: %d", this.item.getStrength()))
                .append(System.lineSeparator())
                .append(String.format(" * Agility: %d", this.item.getAgility()))
                .append(System.lineSeparator())
                .append(String.format(" * Intelligence: %d", this.item.getIntelligence()));

        return builder.toString().trim();
    }
}
