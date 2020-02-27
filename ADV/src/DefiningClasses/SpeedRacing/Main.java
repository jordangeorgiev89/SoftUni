package DefiningClasses.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");

            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuel, consumption);

            cars.put(model, car);
        }

        String line = sc.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            if (!cars.get(model).drive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }

            line = sc.nextLine();
        }
        for (String model : cars.keySet()) {
            System.out.println(cars.get(model).getInfo());
        }
    }
}
