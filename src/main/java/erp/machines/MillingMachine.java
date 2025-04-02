package erp.machines;

import java.util.List;

public class MillingMachine extends Machine {
    private List<Long> productionOrder;
    private String name;


    @Override
    public void start() {

        System.out.println("Machine is starrting: ");
        startTask();
    }

    @Override
    public void stop() {
        stopTask();
    }

    @Override
    public void performTask() {

    }

}