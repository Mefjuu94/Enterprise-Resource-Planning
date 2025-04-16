package erp.databaseUtils;


import erp.machines.Machine;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MachineDAO {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final SessionFactory sessionFactory = UserSessionFactory.getUserSessionFactory();


    public boolean createMachine(Machine machine) {

        Transaction transaction = null;

        System.out.println(sessionFactory.isClosed());
        try (Session session = sessionFactory.openSession()){
            System.out.println("prubuje zapisac " + machine.toString());
            transaction = session.beginTransaction();
            session.merge(machine);
            transaction.commit();

            System.out.println("machine saved");

            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // back transaction when is error
            e.printStackTrace();
            return false;
        }
    }

    public Machine findMachineID(String ID) {
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Machine> userQuery = cb.createQuery(Machine.class);
            Root<Machine> root = userQuery.from(Machine.class);
            userQuery.select(root).where(cb.equal(root.get("id"), ID));
            Machine result = session.createQuery(userQuery).getSingleResultOrNull();
            return result;
        } catch (PersistenceException | IllegalArgumentException e) {
            System.out.println("No entity found with ID: " + ID);
        }
        return null;
    }

    public List<Machine> listAllMachines() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Machine> criteriaQuery = cb.createQuery(Machine.class);
            Root<Machine> root = criteriaQuery.from(Machine.class);
            criteriaQuery.select(root);

            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    public List<Machine> findMachineByName(String name) {
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Machine> userQuery = cb.createQuery(Machine.class);
            Root<Machine> root = userQuery.from(Machine.class);
            userQuery.select(root).where(cb.equal(cb.lower(root.get("name")), name.toLowerCase()));
            List<Machine> results = session.createQuery(userQuery).getResultList();
            return results;
        } catch (PersistenceException | IllegalArgumentException e) {
            System.out.println("No entity found with email: " + name);
        }
        return null;
    }



}
