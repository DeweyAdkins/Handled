package org.example;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readingList; // List to store all readings


    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readingList = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("Average sensor is off or no sensors have been added");
        }
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.read();
        }
        int average = sum / sensors.size();
        readingList.add(average); // Store the reading in the list
        return average;
    }


    public List<Integer> readings() {
        return new ArrayList<>(readingList);
    }

    public static void main(String[] args) {
        TemperatureSensor tempSensor1 = new TemperatureSensor();
        TemperatureSensor tempSensor2 = new TemperatureSensor();
        AverageSensor avgSensor = new AverageSensor();
        avgSensor.addSensor(tempSensor1);
        avgSensor.addSensor(tempSensor2);

        tempSensor1.setOn();
        tempSensor2.setOn();
        avgSensor.setOn();

        System.out.println("Average temperature reading: " + avgSensor.read());
        System.out.println("Average temperature reading: " + avgSensor.read());
        System.out.println("Average temperature reading: " + avgSensor.read());

        System.out.println("All readings: " + avgSensor.readings());
    }
}
