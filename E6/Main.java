package E6;

import E5.Entity.Customer;
import E6.Controller.StaffController;
import E6.Entity.Manager;
import E6.Entity.Staff;
import E6.Entity.Technician;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Staff> staffList = new ArrayList<>();
        staffList.add(new Manager("Alice", 50000, 5000));
        staffList.add(new Manager("Charlie", 60000, 7000));
        staffList.add(new Technician("Bob", 40000, 3000));

        StaffController staffController = new StaffController(staffList);

        staffController.getStaffPaymentByName("Alice");
        staffController.displayStaffInfoByName("Bob");
    }
}
