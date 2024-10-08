package E6.Entity;

public class Manager extends Staff {
    private double allowance;

    public Manager(String name, double salary, double allowance) {
        super(name, salary);
        this.allowance = allowance;
    }


    @Override
    public double getPaid() {
        return getSalary()+allowance;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + this.getName() + '\'' +
                ", salary=" + this.getSalary() +
                ", allowance=" + allowance +
                ", total paid=" + getPaid() +
                '}';
    }
}
