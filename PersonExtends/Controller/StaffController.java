package PersonExtends.Controller;

import PersonExtends.Gender;
import PersonExtends.Staff;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StaffController {
    private static List<Staff> staffs;
    // Constructor to initialize the staff list
    public StaffController(List<Staff> staffs) {
        StaffController.staffs = staffs;
    }
    public Optional<Staff> filterFemaleStaffWithMaxPay() {
        return staffs.stream()
                .filter(staff -> staff.getGender() == Gender.Female)  // Filter by gender
                .max(Comparator.comparingDouble(Staff::getPay));      // Find the staff with the maximum pay
    }
    public static List<Staff> getByName(String Keyword) {
        return staffs.stream()
                .filter(s->s.getName().toLowerCase().contains(Keyword.toLowerCase()))
                .toList();
    }
    public static void changeName(String id,String newName) {
        staffs.stream()
                .filter(staff -> staff.getId().equals(id))
                .forEach(staff -> staff.setName(newName));
    }
}
