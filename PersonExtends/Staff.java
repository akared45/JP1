package PersonExtends;

public class Staff extends Person {
    private int Id;
    private String schoolName;
    private double pay;
    private String position;

    private Gender gender;
    public Staff(){}

    public Staff(int id,String name, String address, String schoolName, double pay, String position, Gender gender) {
        super(name, address);
        Id = id;
        this.schoolName = schoolName;
        this.pay = pay;
        this.position = position;
        this.gender = gender;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "Id=" + Id +
                ", Name='" + this.getName() + '\'' +
                ", Gender='" + gender+ '\'' +
                ", Address='" + this.getAddress() + '\'' +
                ", pay=" + pay +
                ", position='" + position + '\'' +
                "} ";
    }
}
