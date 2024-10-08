package S10;

public class TemperatureException extends Exception {
    private int temperature;

    public TemperatureException(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
