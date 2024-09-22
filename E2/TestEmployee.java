package E2;

public class TestEmployee {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new Employee(1, "Le", "Vinh", 2000);
        employees[1] = new Employee(2, "Tran", "Trung", 3000);
        employees[2] = new Employee(3, "Navi", "s1mple", 6000);

        System.out.println("Original information employee");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }

        employees[0].increaseSalary(10);
        employees[1].increaseSalary(20);
        employees[1].increaseSalary(30);

        System.out.println("Update salary information employee");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
    }
}
