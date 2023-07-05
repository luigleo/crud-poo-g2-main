package g2.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import g2.entities.User;

@Repository
public interface UserRepository extends GenericRepository<User> {
  Optional<User> findByEmail(String email);
}
