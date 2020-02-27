package Exams.June16_2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] a = scanner.nextLine().split("\\s+");
        ArrayDeque<String> products = new ArrayDeque<>();
        ArrayDeque<Integer> salads = new ArrayDeque<>();
        ArrayDeque<Integer> makedSalad = new ArrayDeque<>();

        products.addAll(Arrays.asList(a));

        String[] b = scanner.nextLine().split("\\s+");
        for (int i = 0; i < b.length; i++) {
            int c = Integer.parseInt(b[i]);
            salads.push(c);
        }

        while (!products.isEmpty() && !salads.isEmpty()){
            int calorie = salads.pop();
            makedSalad.add(calorie);

            while (calorie > 0 && !products.isEmpty()){
                String vegetable = products.poll();
                if (vegetable.equals("tomato")){
                    calorie -= 80;

                }else if (vegetable.equals("potato")){
                    calorie -= 215;

                }else if (vegetable.equals("carrot")){
                    calorie -= 136;

                }else if (vegetable.equals("lettuce")){
                    calorie -= 109;
                }
            }
        }

        if (!makedSalad.isEmpty()){
            for (Integer j: makedSalad) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }

        if (!salads.isEmpty()){
            for (Integer j: salads) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }

        if (!products.isEmpty()){
            for (String j: products) {
                System.out.printf("%s ", j);
            }
            System.out.println();
        }
    }
}