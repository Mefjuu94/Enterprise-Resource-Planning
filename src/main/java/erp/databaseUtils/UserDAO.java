package erp.databaseUtils;


import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import erp.user.User;

@Repository
public class UserDAO {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private SessionFactory sessionFactory = UserSessionFactory.getUserSessionFactory();


    public User findUserByID(String ID) {
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> userQuery = cb.createQuery(User.class);
            Root<User> root = userQuery.from(User.class);
            userQuery.select(root).where(cb.equal(root.get("id"), ID));
            User results = session.createQuery(userQuery).getSingleResultOrNull();
            return results;
        } catch (PersistenceException | IllegalArgumentException e) {
            System.out.println("No entity found with ID: " + ID);
        }
        return null;
    }

}
