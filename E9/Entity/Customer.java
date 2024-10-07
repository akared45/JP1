package E9.Entity;

public class Customer {
    private int id;
    private String Name;
    private Gender gender;
    private int discount;

    public Customer() {
    }

    public Customer(int id, String name, Gender gender, int discount) {
        this.id = id;
        Name = name;
        this.gender = gender;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", gender=" + gender +
                ", discount=" + discount +
                '}';
    }
}
