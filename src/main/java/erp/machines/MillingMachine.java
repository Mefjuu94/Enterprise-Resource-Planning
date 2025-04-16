package erp.machines;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class MillingMachine extends Machine {

    private String name;

    public MillingMachine(String name) {
        this.name = name;
    }

    public MillingMachine() {

    }

    @Override
    public void start() {

        System.out.println("Machine " + name + " is starrting: ");
        startTask();
    }

    @Override
    public void stop() {
        stopTask();
    }

    @Override
    public void performTask() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MillingMachine that = (MillingMachine) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "MillingMachine{" +
                "name='" + name + '\'' +
                '}';
    }
}