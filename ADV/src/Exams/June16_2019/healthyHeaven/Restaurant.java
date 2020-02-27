package Exams.June16_2019.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        int less = Integer.MAX_VALUE;
        String healthySalad = "";
        int index = 0;
        for (Salad datum : this.data) {
            if (datum.getTotalCalories() < less) {
                less = datum.getTotalCalories();
                healthySalad = datum.getName();
                index = this.data.indexOf(datum);
            }
        }
        return this.data.get(index);
    }

    public String generateMenu() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(String.format("%s have %d salads:",
                this.name,
                this.data.size())).append(System.lineSeparator());

        sb1.trimToSize();
        if (this.data.size()>0) {
            for (Salad datum : this.data) {
                sb1.append(datum.toString());
            }
            
        }
        return sb1.toString().trim();
    }
}
