import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {

        //Ex2
        // this.removeObjectEx();

        //Ex3
        //  try {
        //      this.containsEmployeeEx();
        //  } catch (IOException e) {
        //      e.printStackTrace();
        //  }

        //Ex4
        // this.employeeWithSalaryOver50000();

        //Ex5
        //this.employeesFromDepartmentEx();

        //Ex6
        //    try {
        //        this.addingNewAddressAndUpdatingEmployee();
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }

        //Ex7
        // this.addressesWithEmployeeCount();

        //Ex8
        // try {
        //     this.GetEmployeeWithProject();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        //Ex9
        // this.FindLatest10Projects();

        //Ex10
        this.increaseSalaries();
        //не е довършена
    }


    private void containsEmployeeEx() throws IOException {
        System.out.println("Enter employee full name:");
        String fullName = reader.readLine();
        try {
            Employee employee = this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                    "WHERE CONCAT(e.firstName,' ',e.lastName)= :name", Employee.class)
                    .setParameter("name", fullName)
                    .getSingleResult();
            System.out.println("Yes");
        } catch (NoResultException nre) {
            System.out.println("No");
        }
    }

    private void removeObjectEx() {
        List<Town> towns = this.entityManager
                .createQuery("SELECT t FROM Town AS t " +
                        "WHERE length(t.name)>5", Town.class)
                .getResultList();
        this.entityManager.getTransaction().begin();
        towns.forEach(this.entityManager::detach);
        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }
        towns.forEach(this.entityManager::merge);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();

    }

    private void employeeWithSalaryOver50000() {
        this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.salary>50000 ", Employee.class)
                .getResultStream()
                .forEach(e -> System.out.printf("%s%n", e.getFirstName()));

    }

    private void employeesFromDepartmentEx() {
        this.entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.department.name='Research and Development'" +
                "ORDER BY e.salary,e.id", Employee.class)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));

    }

    private void addingNewAddressAndUpdatingEmployee() throws IOException {
        System.out.println("Enter employee name:");
        String lastName = this.reader.readLine();
        Employee employee = this.entityManager
                .createQuery("select e from Employee AS e " +
                        "WHERE e.lastName= :name", Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();
        Address address = this.createNewAddress("Vitoshka 15");
        this.entityManager.getTransaction().begin();
        this.entityManager.detach(employee);
        employee.setAddress(address);
        this.entityManager.merge(employee);

        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }

    private Address createNewAddress(String textContent) {
        Address address = new Address();
        address.getText();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(address);
        this.entityManager.getTransaction().commit();

        return address;
    }

    private void addressesWithEmployeeCount() {
        this.entityManager.getTransaction().begin();

        List<Address> list = this.entityManager.createQuery("SELECT e FROM Address AS e " +
                "ORDER BY e.employees.size DESC ,e.town.id")
                .setMaxResults(10)
                .getResultList();
        list.forEach(e ->
                System.out.printf("%s, %s - %d employees%n",
                        e.getText(),
                        e.getTown().getId(),
                        e.getEmployees().size()));
        this.entityManager.getTransaction().commit();
    }

    private void GetEmployeeWithProject() throws IOException {
        System.out.println("Enter employee ID:");
        int id = Integer.parseInt(reader.readLine());
        Employee employee = this.entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.id= :Id", Employee.class)
                .setParameter("Id", id)
                .getSingleResult();
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        employee.getProjects().stream()
                .forEach(project -> System.out.println("      " + project.getName()));


    }

    private void FindLatest10Projects() {
        this.entityManager.getTransaction().begin();
        List<Project> list = this.entityManager.createQuery("SELECT p FROM Project AS p " +
                "ORDER BY p.startDate DESC, p.name", Project.class)
                .setMaxResults(10)
                .getResultList();
        list.forEach(p -> System.out.printf("Project name: %s%n" +
                        "       Project Description: %s%n" +
                        "       Project Start Date:%s%n" +
                        "       Project End Date: %s%n",
                p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate()
        ));


        this.entityManager.getTransaction().commit();
    }

    private void increaseSalaries() {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("UPDATE Employee SET salary=salary*0.12 " +
                "WHERE department.name='Engineering'or " +
                "department.name='Tool Design'Or " +
                "department.name='Information Services'Or " +
                "department.name='Marketing Services'", Employee.class)
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s %s (%.2f)", e.getFirstName(), e.getLastName(), e.getSalary());
                });
        this.entityManager.getTransaction().commit();
    }
}
