package DefiningClasses.CompanyRooster1;

public class Employee {
    private static final String EMAIL_DEF_VALUE = "n/a";
    private static final int AGE_DEF_VALUE = -1;

    private String name;
    private double salary;
    private String email;
    private int age;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.email = Employee.EMAIL_DEF_VALUE;
        this.age = Employee.AGE_DEF_VALUE;

    }

    public Employee(String name, double salary, String email) {
        this(name, salary);
        this.email = email;
    }

    public Employee(String name, double salary, int age) {
        this(name, salary);
        this.age = age;
    }

    public Employee(String name, double salary, String email, int age) {
        this(name, salary, email);
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }
}
