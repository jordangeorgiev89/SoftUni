package Exams.April16_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int waveTrojans = Integer.parseInt(reader.readLine());

        int[] spartanDefense = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> defense = new ArrayDeque<>();
        for (int i : spartanDefense) {
            defense.offer(i);
        }
        ArrayDeque<Integer> trojanWarriors = new ArrayDeque<>();
        for (int i = 1; i <= waveTrojans && !defense.isEmpty(); i++) {

            for (String warrior : (reader.readLine().split("\\s+"))) {
                trojanWarriors.push(Integer.valueOf(warrior));
            }
            if (i % 3 == 0) {
                int reinforcement = Integer.parseInt(reader.readLine());
                defense.offer(reinforcement);
            }

            while (!(trojanWarriors.isEmpty() || defense.isEmpty())) {
                int gateDefense = defense.poll();
                int warrior = trojanWarriors.pop();

                if (warrior > gateDefense) {
                    warrior -= gateDefense;
                    trojanWarriors.push(warrior);
                } else if (gateDefense > warrior) {
                    gateDefense -= warrior;
                    defense.addFirst(gateDefense);
                }
            }
        }


        if (!areTrojanWarriorsWinners(trojanWarriors)) {
            System.out.print("The Spartans successfully repulsed the Trojan attack.\r\nPlates left: ");
            StringBuilder bd = new StringBuilder();
            while (!defense.isEmpty()) {
                bd.append(defense.poll()).append(", ");
            }
            System.out.print(bd.toString().substring(0, bd.length() - 2));
        }


    }

    private static boolean areTrojanWarriorsWinners(ArrayDeque<Integer> trojanWarriors) {
        if (!trojanWarriors.isEmpty()) {
            System.out.print("The Trojans successfully destroyed the Spartan defense.\r\n" +
                    "Warriors left: ");
            System.out.print(trojanWarriors.toString().replaceAll("[\\[\\]]", ""));
            return true;
        }
        return false;
    }
}