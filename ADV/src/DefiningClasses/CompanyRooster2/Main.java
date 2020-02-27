package DefiningClasses.CompanyRooster2;//package DefiningClasses.CompanyRooster2;
//
//import DefiningClasses.CompanyRoster.Department;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Employee.Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = Integer.parseInt(sc.nextLine());
//
//        while (n-- > 0) {
//            String[] tokens = sc.nextLine().split("\\s+");
//
//            HashMap<String, Department> departments = new HashMap<>();
//
//            String departmentName = tokens[3];
//
//            Employee emp = new Employee(
//                    tokens[0],
//                    Double.parseDouble(tokens[1]),
//                    tokens[2]
//            );
//
//            if (tokens.length == 6) {
//                if (Character.isDigit(tokens[4].charAt(0))) {
//                    emp.setAge(Integer.parseInt(tokens[4]));
//                } else {
//                    emp.setEmail(tokens[4]);
//                }
//            } else if (tokens.length == 6) {
//                emp.setEmail(tokens[4]);
//                emp.setAge(Integer.parseInt(tokens[5]));
//            }
//            if (!departments.containsKey(departmentName)) {
//                departments.put(departmentName, new Department());
//            }
//            departments.get(departmentName).addEmployee();
//        }
//    }
//}
