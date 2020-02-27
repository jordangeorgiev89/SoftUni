package Exams.June16_2019.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
        int sumCalories = 0;

        if (this.products.size()> 0){
            for (Vegetable product : this.products) {
                sumCalories += product.getCalories();
            }
        }
        return sumCalories;

    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(String.format("* Salad %s is %d calories and have %d products:",
                this.getName(),
                this.getTotalCalories(),
                this.getProductCount())).append(System.lineSeparator());
sb.trimToSize();
        if (this.products.size()>0) {
            for (int i = 0; i < this.products.size(); i++) {
                sb.append(this.products.get(i).toString()).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
