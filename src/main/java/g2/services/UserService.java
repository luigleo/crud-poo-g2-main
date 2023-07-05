package g2.services;

import g2.entities.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends GenericService<User>, UserDetailsService {
}
