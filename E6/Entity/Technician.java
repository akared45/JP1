package E6.Entity;

public class Technician extends Staff{
    private double overtimePay;

    public Technician(String name, double salary, double overtimePay) {
        super(name, salary);
        this.overtimePay = overtimePay;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }


    @Override
    public double getPaid() {
        return getSalary()+overtimePay;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + this.getName() + '\'' +
                ", salary=" + this.getSalary() +
                ", overtime=" + overtimePay +
                ", total paid=" + getPaid() +
                '}';
    }
}
