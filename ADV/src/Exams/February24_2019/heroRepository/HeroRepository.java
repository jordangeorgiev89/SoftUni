package Exams.February24_2019.heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero hero) {
        this.data.add(hero);
    }

    public void remove(String name) {
        for (Hero hero : this.data) {
            if (hero.getName().equals(name)) {
                this.data.remove(hero);
                break;
            }
        }
    }

    public Hero getHeroWithHighestStrength() {
        int highestStrength = Integer.MIN_VALUE;
        Hero mostStrength = null;

        for (Hero hero : this.data) {
            if (hero.getItem().getStrength() > highestStrength) {
                highestStrength = hero.getItem().getStrength();
                mostStrength = hero;
            }
        }

        return mostStrength;
    }

    public Hero getHeroWithHighestAgility() {
        int highestAgility = Integer.MIN_VALUE;
        Hero highestA = null;

        for (Hero hero : this.data) {
            if (hero.getItem().getAgility() > highestAgility) {
                highestAgility = hero.getItem().getAgility();
                highestA = hero;
            }
        }

        return highestA;
    }

    public Hero getHeroWithHighestIntelligence() {
        int highestIntelligence = Integer.MIN_VALUE;
        Hero highestI = null;

        for (Hero hero : this.data) {
            if (hero.getItem().getIntelligence() > highestIntelligence) {
                highestIntelligence = hero.getItem().getIntelligence();
                highestI = hero;
            }
        }

        return highestI;
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Hero hero : this.data) {
            stringBuilder.append(hero.toString())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
