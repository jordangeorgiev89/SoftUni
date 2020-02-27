import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Engine implements Runnable{

    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine (EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
//        ex 1
//        this.removeObjectsEx();
//        ex 2
//        try {
//            this.containsEmployeeEx();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ex 4
//        this.employeeWithSalaryOver50000();
//        ex 5
//        this.employeesFromDepartmentEx();
//        ex 6
//        try {
//            this.addingNewAddressAndAddItToEmp();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    private void employeeWithSalaryOver50000Ex() {
//        List<Employee> employees = this.entityManager
//                .createQuery("SELECT e FROM Employee AS e " +
//                        "WHERE e.salary > 50000", Employee.class)
//                .getResultList();
//
//        System.out.println();

        this.entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .forEach(e -> System.out.printf("%s%n", e.getFirstName()));
    }

    private void containsEmployeeEx() throws IOException {
        System.out.println("Enter employee full name:");

        String fullName = this.reader.readLine();

        try {

        Employee employee = this.entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE concat(e.firstName, ' ', e.lastName) = :name", Employee.class)
                .setParameter("name", fullName)
                .getSingleResult();
        System.out.println("Yes");
        }catch (NoResultException nre) {
            System.out.println("No");
        }

    }

    private void removeObjectsEx() {
        List<Town> towns = this.entityManager
                .createQuery("SELECT t FROM Town As t " + "WHERE length(t.name) > 5", Town.class)
                .getResultList();

        this.entityManager.getTransaction().begin();

        towns
                .forEach(this.entityManager::detach);

        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }

        towns.forEach(this.entityManager::merge);

        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }

    private void employeesFromDepartmentEx() {
        List<Employee> employees = this.entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name = 'Research and Development' " +
                        "ORDER BY e.salary, e.id ", Employee.class)
                .getResultList();

        System.out.println();
    }

    private void addingNewAddressAndAddItToEmp() throws IOException {
        System.out.println("Enter emp last name");
        String lastName = this.reader.readLine();

        Employee employee = this.entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.lastName = :name", Employee.class)
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
        address.setText("textContent");

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(address);
        this.entityManager.getTransaction().commit();

        return address;
    }
}
