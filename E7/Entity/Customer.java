package E7.Entity;

public class Customer {
    private int id;
    private String code;
    private String name;
    private Gender gender;

    public Customer() {
    }

    public Customer(int id, String code, String name,Gender gender) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
