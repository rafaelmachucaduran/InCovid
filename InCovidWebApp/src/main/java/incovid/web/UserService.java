package incovid.web;

import incovid.model.User;
import incovid.web.dto.UserRegistrationDto;

public interface UserService {
    User save (UserRegistrationDto userRegistrationDto);
    User getUserPorId(long id);
    boolean existeUserPorUsername(String username);
    void activarUsuarioId(long id);
    void actualizarUsuario(User userActualiar);
    String autoPassword(User user);
}
