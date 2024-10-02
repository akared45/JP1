package E6.Controller;

import E6.Entity.Staff;

import java.util.List;
import java.util.Optional;

public class StaffController {
    private static List<Staff> staffs;

    public StaffController(List<Staff> staffs) {
        StaffController.staffs = staffs;
    }

    public void displayStaffInfoByName(String name) {
        List<Staff> foundStaff = staffs.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .toList();

        if (!foundStaff.isEmpty()) {
            foundStaff.forEach(System.out::println);
        } else {
            System.out.println("Staff with name " + name + " not found.");
        }
    }

    public void getStaffPaymentByName(String name) {
        staffs.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(s -> System.out.println(s.getName() + " is paid: " + s.getPaid()));
    }

}
