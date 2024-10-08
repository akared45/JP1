package S10;

public class CoffeeCup {
    private int temperature = 75;
    private String flavor = "terrible";

    public void setTemperature(int val) {
        temperature = val;
    }

    public int getTemperature() {
        return temperature;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }
}
