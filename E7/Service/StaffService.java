package E7.Service;

import E7.Entity.Staff;
import E7.Global.Global;
import E7.IGeneric.IGeneral;

import java.util.List;

public class StaffService implements IGeneral<Staff> {
    private final List<Staff> staffList;

    public StaffService(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public Staff getById(int id) {
        for (Staff staff : staffList) {
            if (staff.getId() == id) {
                return staff;
            }
        }
        return null;
    }

    @Override
    public Staff getByCode(String code) {
        for (Staff staff : staffList) {
            if (staff.getCode().equalsIgnoreCase(code)) {
                return staff;
            }
        }
        return null;
    }

    @Override
    public List<Staff> getByName(String keyword) {
        return this.staffList.stream().filter((c) -> {
            return Global.ignoreCase(c.getName(), keyword);
        }).toList();
    }
}
