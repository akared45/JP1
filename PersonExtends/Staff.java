package PersonExtends;

public class Staff extends Person {
    private String Id;
    private String schoolName;
    private double pay;
    private String position;

    private Gender gender;
    public Staff(){}

    public Staff(String id,String name, String address, String schoolName, double pay, String position, Gender gender) {
        super(name, address);
        this.Id = id;
        this.schoolName = schoolName;
        this.pay = pay;
        this.position = position;
        this.gender = gender;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
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
    public String getName(){
        return "Student Name: " + super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
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
