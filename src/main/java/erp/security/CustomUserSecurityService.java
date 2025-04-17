package erp.security;

import erp.databaseUtils.UserDAO;
import erp.customUser.CustomUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserSecurityService implements UserDetailsService {

    private final UserDAO dao = new UserDAO();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        CustomUser customUser = dao.findUserByID(username);

        System.out.println(customUser);

        return org.springframework.security.core.userdetails.User.withUsername(customUser.getName())
                .password(customUser.getPassword())
                .authorities("USER").build();
    }
}
