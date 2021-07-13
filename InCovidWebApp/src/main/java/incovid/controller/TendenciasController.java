package incovid.controller;

import incovid.db.UserLogged;
import incovid.db.UserRepository;
import incovid.tendencias.CalculadoraTendencias;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("tendencias")
public class TendenciasController {
    CalculadoraTendencias calculadoraTendencias;
    String resultado;
    ArrayList<String> comunidades = null;
    UserRepository userRepository;

    public TendenciasController(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    private static String[] CCAA = {"Andalucia", "Aragon", "Asturias", "Cantabria", "Castilla-La Mancha",
            "Castilla y Leon", "Cataluña", "Ceuta", "Extremadura", "Galicia", "Islas Baleares", "Islas Canarias",
            "La Rioja", "Madrid", "Melilla", "Murcia", "Navarra", "Pais Vasco", "Valencia"};

    private void anyadirComunidadesALista(){
        comunidades = new ArrayList<>();
        for(int i = 0; i < CCAA.length; i++){
            comunidades.add(CCAA[i]);
        }
    }

    @GetMapping("index")
    public String index(Model model){
        CalculadoraTendencias calculadoraTendencias = new CalculadoraTendencias();
        anyadirComunidadesALista();
        model.addAttribute("listaComunidades", comunidades);
        model.addAttribute("calculadoraTendencias", calculadoraTendencias);
        model.addAttribute("resultado", resultado);
        return "tendencias/index";
    }

    @ModelAttribute("calculadoraTendencias")
    public CalculadoraTendencias calculadoraTendencias() {
        return new CalculadoraTendencias();
    }

    @GetMapping("calcularTendencias")
    public String verFormularioActualizar() {
        return "/calculadoraTendencias/index";
    }

    @GetMapping("calcularTendenciasYCorreo")
    public String verFormularioActualizarYCorreo() {

        if(this.calculadoraTendencias.enviarCorreo(userRepository.findByUsername(new UserLogged().getUser()).getMail())){
            return "redirect:/tendencias/index?correo";
        }else{
            return "redirect:/tendencias/index?NoCorreo";
        }
    }

    @GetMapping("enviarSMS")
    public String enviarSMS() {

        return "redirect:/tendencias/index?sms";
    }


    @PostMapping()
    public String enviarDatos(@ModelAttribute("calculadoraTendencias") CalculadoraTendencias calculadoraTendencias){
        this.calculadoraTendencias = calculadoraTendencias;
        resultado = calculadoraTendencias.ejecutar();

        return "redirect:/tendencias/index?tendencias";
    }
}
