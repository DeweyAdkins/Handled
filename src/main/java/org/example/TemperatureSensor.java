package org.example;
import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn;

    public TemperatureSensor() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;
    }

    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        if (!isOn) {
            throw new IllegalStateException("Temperature sensor is off");
        }
        Random random = new Random();
        return random.nextInt(61) - 30;
    }

    public static void main(String[] args) {
        TemperatureSensor tempSensor = new TemperatureSensor();
        tempSensor.setOn();
        System.out.println("Temperature reading: " + tempSensor.read());
    }
}
