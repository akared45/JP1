package Entity;

public class Customer {
    private int id;
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;

    // Getter and Setter for id
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for gender
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter and Setter for address
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for phoneNumber
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter for email
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Customer(){
        System.out.println("This is customer");
    }
    public Customer( int id , String name){
        this.id=id;
        this.name=name;
    }
    @Override
    public String toString(){
        return "{Id: " + this.getId()+ "\tName: "+ this.getName()+"}";
    }
}
