package E7.Controller;

import E7.Entity.Staff;
import E7.Service.StaffService;

import java.util.List;

public class StaffController {
    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    public Staff getById(int id) {
        return this.staffService.getById(id);
    }

    public Staff getByCode(String code) {
        return this.staffService.getByCode(code);
    }

    public List<Staff> getByName(String keyword) {
        return this.staffService.getByName(keyword);
    }
}
