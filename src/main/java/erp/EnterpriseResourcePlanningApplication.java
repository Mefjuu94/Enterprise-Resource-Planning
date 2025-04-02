package erp;

import erp.machines.Machine;
import erp.machines.MillingMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnterpriseResourcePlanningApplication {

    public static void main(String[] args) {
        Machine miling = new MillingMachine();
        miling.start();
        SpringApplication.run(EnterpriseResourcePlanningApplication.class, args);


       miling.stop();


        System.out.println(miling.getTotalWorkTime());

    }
}
