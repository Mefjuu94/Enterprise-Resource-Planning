package erp;

import erp.databaseUtils.MachineDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnterpriseResourcePlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterpriseResourcePlanningApplication.class, args);

        MachineDAO machineDAO = new MachineDAO();
//        System.out.println(machineDAO.findMachineID(String.valueOf(1)));

    }
}
