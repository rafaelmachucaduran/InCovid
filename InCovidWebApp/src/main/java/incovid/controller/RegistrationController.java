package incovid.controller;


import incovid.model.ValidadorCampos;
import incovid.web.UserService;
import incovid.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        //System.out.println(registrationDto.getUsername());
        if(userService.existeUserPorUsername(registrationDto.getUsername())) return "redirect:/registration?existe";
        else if(!new ValidadorCampos().validarDNI(registrationDto.getUsername())) return "redirect:/registration?dni";
        else if(!new ValidadorCampos().validarMail(registrationDto.getEmail())) return "redirect:/registration?mail";
        userService.save(registrationDto);
        return "redirect:/registration?success";

    }

}
