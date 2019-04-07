import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {

    private String fullname;
    private String department;
    private double salary;

    public Employee(String fullname, String department, double salary) {
        this.fullname = fullname;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }
}

public class IndexRunner {

    /*
    zamodeluj klasę Pracownika z polami:
    fullname, salary, department
    Utwórz listę kilku pracowników
    Wyświetl departamenty z liczbą pracowników
    Wyświetl departamenty z sumą płac.

     */

    static List<Employee> employees = Arrays.asList(
        new Employee("Jim Beam", "Accountant", 3500.00),
        new Employee("Ben Ten", "IT", 4900.00),
        new Employee("Alice Smith", "Accountant", 4100.00),
        new Employee("Jack Doe", "Marketing", 3890.00),
        new Employee("Bill Dean", "Marketing", 3500.00),
        new Employee("John Romita", "Marketing", 3500.00),
        new Employee("Sam Rock", "IT", 6500.00),
        new Employee("Rob Newman", "Marketing", 2900.00)
    );

    //Accountant - 2
    //IT - 2
    //Marketing - 4

    //Accountant - sumaPlac
    //IT - sumaPlac
    //Marketing - sumaPlac

    public static void main(String[] args) {
        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();
        for (Employee employee : employees) {
            if (!employeesByDepartment.containsKey(employee.getDepartment())) {
                List<Employee> employees = new ArrayList<>();
                employees.add(employee);
                employeesByDepartment.put(employee.getDepartment(), employees);
            } else {
                employeesByDepartment.get(employee.getDepartment())
                    .add(employee);
            }
        }

        employeesByDepartment.entrySet().forEach(
            e -> System.out.println(e.getKey() + " " + e.getValue().size())
        );

        employeesByDepartment
            .entrySet().stream()
            .forEach(e -> {
                Double salarySum = calculateSalarySum(e.getValue());
                System.out.println(e.getKey() + " " + salarySum);
            });
    }

    private static Double calculateSalarySum(List<Employee> employees) {
        return employees.stream()
            .map(employee -> employee.getSalary())
            .reduce(0.0, (a, e) -> a + e);
    }


}
