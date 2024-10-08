package S10;

public class VirtualCafe {
    public static void serveCustomer(VirtualPerson cust, CoffeeCup cup)throws UnusualTasteException {
        try {
            cust.drinkCoffee(cup);
            System.out.println("Cà phê có nhiệt độ vừa phải.");
        } catch (TooColdException e) {
            System.out.println("Cà phê quá lạnh! Nhiệt độ là: " + e.getTemperature() + "°C");
        } catch (TooHotException e) {
            System.out.println("Cà phê quá nóng! Nhiệt độ là: " + e.getTemperature() + "°C");
        } catch (TooBadException e){
            System.out.println("Cà phê dở quá! Hương vị cà phê: " + e.getMessage());
        }
    }
}
