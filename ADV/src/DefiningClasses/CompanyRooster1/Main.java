package DefiningClasses.CompanyRooster1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        HashMap<String, Department> departments = new HashMap<>();

        while (n-- > 0) {

            String[] tokens = sc.nextLine().split("\\s+");

            String departmentName = tokens[3];

            Employee employee = null;

            switch (tokens.length) {
                case 4:
                    employee = new Employee(tokens[0],
                            Double.parseDouble(tokens[1])
                    );
                    break;
                case 5:
                    if (tokens[4].contains("@")) {
                        employee = new Employee(tokens[0],
                                Double.parseDouble(tokens[1]),
                                tokens[4]
                        );
                    } else {
                        employee = new Employee(tokens[0],
                                Double.parseDouble(tokens[1]),
                                Integer.parseInt(tokens[4])
                        );
                    }
                    break;
                default:
                    employee = new Employee(
                            tokens[0],
                            Double.parseDouble(tokens[1]),
                            tokens[4],
                            Integer.parseInt(tokens[5])
                    );
            }
            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department(departmentName));
            }
            departments.get(departmentName).getEmployees().add(employee);
        }
//        departments.entrySet().stream().sorted((f, s) -> s.getValue().getAverageSalary().)
    }
}
