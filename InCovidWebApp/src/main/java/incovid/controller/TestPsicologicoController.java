package incovid.controller;

import incovid.db.UserLogged;
import incovid.db.UserRepository;
import incovid.testPsicologico.TestPsicologico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testPsicologico")
public class TestPsicologicoController {
    TestPsicologico test=new TestPsicologico();
    int ptosTotales = test.getPuntosTotales();
    char p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20;
    int resultado;
    private UserRepository userRepository;
    public TestPsicologicoController(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }
    public int getResultado(){
        return resultado;
    }
    public int getPtosTotales(){
        return ptosTotales;
    }
    public TestPsicologico getTest(){
        return test;
    }


    public String getEmail(){
        return userRepository.findByUsername(new UserLogged().getUser()).getEmail();
    }

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("testPsicologico",test);
        model.addAttribute("p1", p1);
        model.addAttribute("p2", p2);
        model.addAttribute("p3", p3);
        model.addAttribute("p4", p4);
        model.addAttribute("p4", p4);
        model.addAttribute("p5", p5);
        model.addAttribute("p6", p6);
        model.addAttribute("p7", p7);
        model.addAttribute("p8", p8);
        model.addAttribute("p9", p9);
        model.addAttribute("p10", p10);
        model.addAttribute("p11", p11);
        model.addAttribute("p12", p12);
        model.addAttribute("p13", p13);
        model.addAttribute("p14", p14);
        model.addAttribute("p15", p15);
        model.addAttribute("p16", p16);
        model.addAttribute("p17", p17);
        model.addAttribute("p18", p18);
        model.addAttribute("p19", p19);
        model.addAttribute("p20", p20);
        model.addAttribute("resultado",resultado);
        return "/testPsicologico/index";}

    @GetMapping("realizarTest")
    public String verTest(){return "/realizarTest/index";}


    @ModelAttribute("testPsicologico")
    public TestPsicologico testPsicologico() {
        return new TestPsicologico();
    }
    @PostMapping()
    public String enviarDatos(@ModelAttribute("realizarTest") TestPsicologico test){
        this.test = test;
        String res;
        resultado = test.calcularResultado();
        ptosTotales=test.getPuntosTotales();
        AyudaTestController a = new AyudaTestController(this);
        if (resultado == -1){
            return "redirect:/testPsicologico/realizarTest?testPsicologico";
        }else if(resultado > ptosTotales - 5) {
            return "redirect:/ayuda/ayudaUrgente?testPsicologico"; // Le ha afectado bastante la pandemia
        }else if(resultado > ptosTotales - 12) {
            return "redirect:/ayuda/ayudaSeria?testPsicologico"; // Le ha afectado
        }else if(resultado > ptosTotales - 27) {
            return "redirect:/ayuda/ayudaNormal?testPsicologico"; //NECESITA AYUDA
        }else if(resultado > ptosTotales - 42) {
            return "redirect:/ayuda/ayudaPositiva?testPsicologico"; //NO LE HA AFECTADO TANTO
        } else {
            return "redirect:/ayuda/correcto?testPsicologico"; //NO TE HA AFECTADO
        }
    }
}