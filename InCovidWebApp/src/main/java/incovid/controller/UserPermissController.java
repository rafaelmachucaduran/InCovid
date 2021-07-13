package incovid.controller;

import incovid.db.UserRepository;
import incovid.model.User;
import incovid.notificaciones.enviar;
import incovid.web.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/userPermiss")
public class UserPermissController {
    User user;
    long id;
    String pass;
    String notif;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public UserPermissController(UserService userService, UserRepository userRepository) {
        super();
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("index")
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers", userRepository.findAll());
        model.addAttribute("pass", pass);
        return "userPermiss/index";
    }
    //ACTIVAR USUARIO
    @GetMapping("activarUsuario/{id}")
    public String activarUsuario(@PathVariable (value = "id") long id) {
        // activar usuario
        boolean estadoAct = this.userService.getUserPorId(id).getActive();
        this.userService.activarUsuarioId(id);
        if(estadoAct) return "redirect:/userPermiss/index?desactivado";
        else return "redirect:/userPermiss/index?activado";
    }

    //ACTUALIZAR USUARIO
    @ModelAttribute("user")
    public User userActualizar() {
        return new User();
    }

    @GetMapping("actualizarInfo/{id}")
    public String verFormularioActualizar(@PathVariable (value = "id") long id) {
        this.id = id;
        return "/actualizarInfo/index";
    }

    @PostMapping()
    public String actualizarUser( @ModelAttribute("user") User userActualizar) {
        userActualizar.setId(id);
        userService.actualizarUsuario(userActualizar);

        return "redirect:/userPermiss/index?actualizado";
    }

    //AUTO-PASSWORD GENERATOR
    @GetMapping("autoPassword/{id}")
    public String autoPassword(@PathVariable (value = "id") long id) {

        user = this.userService.getUserPorId(id);
        pass = this.userService.autoPassword(user);

        notif = "<!doctype html>\n"+
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n"+"<title>\n"+"Envio resultados"+"</title>\n" +
                "<td style='text-align:left; padding-right: 10px; border-top: 1px solid #cccccc;'>\n" +
                "<span style='padding:8px 0px; display: inline-block;'>\n" +
                "La contraseña autogenerada para su usuario es la siguiente"+": "+pass+"<br />"+
                "Por favor, se ruega que mantenga esta contraseña en secreto y que no se la muestre a nadie."+
                "</span>\n"+"<br />\n"+"</td>\n"+"</body>\n"+"</html>";

        Thread t1 = new Thread(() -> new enviar().enviarCorreo(notif,user.getMail()));
        t1.start();

        return "redirect:/userPermiss/index?password";
    }
}