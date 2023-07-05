package g2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g2.entities.User;
import g2.services.GenericService;
import g2.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends GenericController<User> {
  final UserService userService;

  public UserController(UserService userService) {
    super();
    this.userService = userService;
  }

  @Override
  GenericService<User> getService() {
    return userService;
  }
}
