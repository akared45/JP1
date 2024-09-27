package PersonExtends;
import PersonExtends.Controller.StaffController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args){
        List<Staff> staffs = new ArrayList<Staff>();
        staffs.add(new Staff("1", "Vinh", "Le", "ABC123", 10000, "Employee", Gender.Male));
        staffs.add(new Staff("2", "Mai", "Pham", "DEF456", 12000, "Manager", Gender.Female));
        staffs.add(new Staff("3", "Hanh", "Tran", "GHI789", 12000, "Developer", Gender.Female));

        StaffController staffController = new StaffController(staffs);
        Optional<Staff> highestPaidFemaleStaff = staffController.filterFemaleStaffWithMaxPay();
        System.out.println(highestPaidFemaleStaff);

        List<Staff> searchedStaff = StaffController.getByName("Vinh");
        searchedStaff.forEach(System.out::println);

        StaffController.changeName("2", "Vinh New");
        staffs.forEach(System.out::println);

    }
}
