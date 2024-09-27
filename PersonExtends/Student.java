package PersonExtends;

import java.time.LocalDate;

public class Student extends Person{
    private int Id;
    private LocalDate Dob;
    private Gender gender;

    public Student(){}

    public Student(int id, String name, String address , LocalDate dob, Gender gender) {
        super(name, address);
        Id = id;
        Dob = dob;
        this.gender = gender;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getMinAge(){
        return Math.abs(LocalDate.now().getYear()-this.getDob().getYear());
    }

    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name=" + this.getName() +
                ", Dob=" + Dob +
                ", Age=" + this.getMinAge() +
                ", Gender=" + gender +
                ", Address=" + this.getAddress() +
                "} " ;
    }
}
