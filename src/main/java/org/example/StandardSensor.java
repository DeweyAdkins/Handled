package org.example;

public class StandardSensor implements Sensor {
    private int value;


    public StandardSensor(int value) {
        this.value = value;
    }


    @Override
    public boolean isOn() {
        return true;
    }


    @Override
    public void setOn() {
        // No operation, as the sensor is always on
    }


    @Override
    public void setOff() {
        // No operation, as the sensor is always on
    }


    @Override
    public int read() {
        return this.value;
    }

    // Main method for testing
    public static void main(String[] args) {
        StandardSensor sensor = new StandardSensor(42);
        System.out.println("Sensor is on: " + sensor.isOn()); // Output: true
        sensor.setOff(); // No effect
        System.out.println("Sensor is on: " + sensor.isOn()); // Output: true
        System.out.println("Sensor reading: " + sensor.read()); // Output: 42
    }
}
