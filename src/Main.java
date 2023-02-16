import java.util.Random;

public class Main {
    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        fillEmployees();
        printFullInfo();
        System.out.println("Сумма ЗП: " + totalSalaries());
        System.out.println("Сумма с минимальной ЗП: " + findEmployeeWithMinSalary());
        System.out.println("Сумма с максимальной ЗП: " + findEmployeeWithMaxSalary());
        System.out.println("Сумма с средней ЗП: " + findAveragesSalary());
        printFullNameInfo();
    }

    private static void fillEmployees() {
        Random random = new Random();

        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = new Employee(
                    "Сотрудник " + (i + 1),
                    random.nextInt(6) + 1,
                    random.nextInt(45_000) + 45_000
            );
        }
    }

    private static void printFullInfo() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    } //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).

    private static int totalSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    } // Сумма Зарплат Сотрудников

    private static Employee findEmployeeWithMinSalary() {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for (Employee emp : EMPLOYEES) {
            if (emp.getSalary() < min) {
                min = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    } // Найти сотрудника с минимальной зарплатой.

    private static Employee findEmployeeWithMaxSalary() {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for (Employee emp : EMPLOYEES) {
            if (emp.getSalary() > max) {
                max = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }  // Найти сотрудника с максимальной зарплатой.

    private static double findAveragesSalary() {
        return totalSalaries() / (double)EMPLOYEES.length;
    } // Найти сотрудника с средней зарплатой.

    private static void printFullNameInfo() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    } //Получить Ф. И. О. всех сотрудников (вывести в консоль).

}