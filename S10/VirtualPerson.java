package S10;
public class VirtualPerson {
    private static final int tooCold = 65;
    private static final int tooHot = 85;

    public void drinkCoffee(CoffeeCup cup) throws TooColdException, TooHotException ,TooBadException{
        int temperature = cup.getTemperature();
        if ("terrible".equals(cup.getFlavor())) {
            throw new TooBadException("Cà phê có vị quá tệ!");
        }
        if (temperature <= tooCold) {
            throw new TooColdException(temperature);
        } else if (temperature >= tooHot) {
            throw new TooHotException(temperature);
        }

    }
}
