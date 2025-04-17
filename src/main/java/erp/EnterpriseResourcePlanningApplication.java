package erp;

import erp.customUser.CustomUser;
import erp.databaseUtils.MachineDAO;
import erp.databaseUtils.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnterpriseResourcePlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterpriseResourcePlanningApplication.class, args);

//        CustomUser customUser = new CustomUser("123",0,"testUser1");
//        UserDAO userDAO = new UserDAO();
//        userDAO.createUser(customUser);

    }
}
