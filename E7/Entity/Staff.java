package E7.Entity;

import java.time.LocalDateTime;

public class Staff {
    private int id;
    private String code;
    private String name;
    private LocalDateTime DoB;

    public Staff() {
    }

    public Staff(int id, String code, String name, LocalDateTime doB) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.DoB = doB;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDoB() {
        return this.DoB;
    }

    public void setDoB(LocalDateTime doB) {
        this.DoB = doB;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", DoB=" + DoB +
                '}';
    }
}
