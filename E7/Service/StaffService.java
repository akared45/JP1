package E7.Service;

import E7.Entity.Staff;
import E7.Global.Global;
import E7.IGeneric.IGeneral;

import java.util.List;

public class StaffService implements IGeneral<Staff> {
    private List<Staff> staffList;

    public StaffService(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public Staff getById(int id) {
        return staffList.stream()
                .filter(staff -> staff.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Staff getByCode(String code) {
        return staffList.stream()
                .filter(staff -> staff.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Staff> getByName(String keyword) {
        return staffList.stream()
                .filter(staff -> Global.ignoreCase(staff.getName(), keyword))
                .toList();
    }
}
