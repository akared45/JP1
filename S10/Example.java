package S10;

public class Example {
    public static void main(String[] args) throws TemperatureException {
        CoffeeCup cup = new CoffeeCup();
        cup.setTemperature(90);
        cup.setFlavor("terrible");
        try {
            VirtualPerson cust = new VirtualPerson();
            VirtualCafe.serveCustomer(cust, cup);
        } catch (UnusualTasteException e) {
            System.out.println("Cà phê này có vị bất thường.");
        }
    }
}
