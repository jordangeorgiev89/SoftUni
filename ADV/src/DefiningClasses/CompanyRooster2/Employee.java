package DefiningClasses.CompanyRooster2;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = "n/a";
        this.age = -1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}