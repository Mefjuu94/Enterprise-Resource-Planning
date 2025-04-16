package erp.databaseUtils;


import erp.customUser.CustomUser;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private SessionFactory sessionFactory = UserSessionFactory.getUserSessionFactory();

    public boolean createUser(CustomUser customUser) {

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(customUser);
            transaction.commit();

            System.out.println("CustomUser saved");
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // back transaction when is error
            e.printStackTrace();
            return false;
        }
    }

    public CustomUser findUserByID(String ID) {
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<CustomUser> userQuery = cb.createQuery(CustomUser.class);
            Root<CustomUser> root = userQuery.from(CustomUser.class);
            userQuery.select(root).where(cb.equal(root.get("id"), ID));
            CustomUser results = session.createQuery(userQuery).getSingleResultOrNull();
            return results;
        } catch (PersistenceException | IllegalArgumentException e) {
            System.out.println("No entity found with ID: " + ID);
        }
        return null;
    }

}
