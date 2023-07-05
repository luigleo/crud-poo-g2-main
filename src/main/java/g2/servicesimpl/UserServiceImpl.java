package g2.servicesimpl;

import g2.entities.User;
import g2.repositories.GenericRepository;
import g2.repositories.UserRepository;
import g2.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    super();
    this.userRepository = userRepository;
  }

  @Override
  public GenericRepository<User> getRepository() {
    return userRepository;
  }

  @Override
  public void validarSave(User objeto) throws Exception {
    UserService.super.validarSave(objeto);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return this.userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
  }
}
