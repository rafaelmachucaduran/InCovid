package incovid.web;

import incovid.db.UserRepository;
import incovid.model.User;
import incovid.security.AutoPassword;
import incovid.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {

        User user = new User (userRegistrationDto.getUsername(), passwordEncoder.encode(userRegistrationDto.getPass()),
                userRegistrationDto.getEmail());
        return userRepository.save(user);

    }

    @Override
    public User getUserPorId(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
        return user;
    }

    @Override
    public boolean existeUserPorUsername(String username) {
        if(this.userRepository.findByUsername(username) == null) return false;
        return  true;

    }

    @Override
    public void activarUsuarioId(long id) {
        this.userRepository.findById(id).get().activarUser();
        this.userRepository.save(userRepository.findById(id).get());
    }

    @Override
    public void actualizarUsuario(User userActualiar) {
        User user = this.userRepository.findById(userActualiar.getId()).get();
        if (userActualiar.getRoles().equals("delete")) user.setRoles(null);
        else if(userActualiar.getRoles() != "") user.setRoles(userActualiar.getRoles());
        if (userActualiar.getPermissions().equals("delete")) user.setPermissions(null);
        else if(userActualiar.getPermissions() != "") user.setPermissions(userActualiar.getPermissions());

        this.userRepository.save(user);
    }

    @Override
    public String autoPassword(User user) {
        String p;
        AutoPassword pass = new AutoPassword();
        p = pass.generar();
        user.setPassword(passwordEncoder.encode(p));
        this.userRepository.save(user);
        return p;
    }

}
