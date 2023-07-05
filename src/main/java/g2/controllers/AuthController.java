package g2.controllers;

import java.security.SecureRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g2.controllers.payloads.LoginPayload;
import g2.controllers.payloads.SignupPayload;
import g2.entities.User;
import g2.helpers.JwtUtils;
import g2.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;
  private final UserService userService;

  public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserService userService) {
    super();
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
    this.userService = userService;
  }

  @PostMapping("/signup")
  public ResponseEntity<Object> signup(@RequestBody SignupPayload signup) {
    User userNovo = new User();
    userNovo.setNome(signup.getNome());
    userNovo.setEmail(signup.getEmail());

    String password = gerarSenhaAleatoria(15);
    userNovo.setSenha(new BCryptPasswordEncoder().encode(password));

    try {
      userService.save(userNovo);
      return ResponseEntity.status(HttpStatus.OK).body(password);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @PostMapping("/signin")
  public ResponseEntity<Object> signin(@RequestBody LoginPayload login) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getSenha()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String tokenJwt = jwtUtils.generateTokenFromEmail(login.getEmail());
    return ResponseEntity.ok().body(tokenJwt);
  }

  private String gerarSenhaAleatoria(int tamanho) {
    String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

    SecureRandom random = new SecureRandom();
    StringBuilder senha = new StringBuilder(tamanho);

    for (int i = 0; i < tamanho; i++) {
      int indice = random.nextInt(CARACTERES_PERMITIDOS.length());

      senha.append(CARACTERES_PERMITIDOS.charAt(indice));
    }

    return senha.toString();
  }
}
