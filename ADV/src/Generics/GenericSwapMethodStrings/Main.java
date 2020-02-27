package Generics.GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Box<String>> boxes = new ArrayList<>();

        while (n-- > 0) {
            String str = sc.nextLine();

            Box<String> box = new Box<>(str);

            boxes.add(box);
        }

        int firstIndex = sc.nextInt();
        int secondIndex = sc.nextInt();

        swapElements(boxes, firstIndex, secondIndex);

        for (Box<String> box : boxes) {
            System.out.println(box.toString());
        }
    }

    private static <T> void swapElements(List<Box<T>> boxes,
                                         int firstIndex,
                                         int secondIndex) {
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);


    }
}
