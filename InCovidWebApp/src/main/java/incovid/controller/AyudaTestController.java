package incovid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ayuda")
public class AyudaTestController {
    private TestPsicologicoController test;
    public AyudaTestController(TestPsicologicoController test){
        this.test = test;
    }

    @GetMapping("ayudaUrgente")
    public String ayudaUrgente(){
        return "ayuda/ayudaUrgente";
    }
    @GetMapping("ayudaSeria")
    public String ayudaSeria(){
        return "ayuda/ayudaSeria";
    }
    @GetMapping("ayudaNormal")
    public String ayudaNormal(){
        return "ayuda/ayudaNormal";
    }
    @GetMapping("ayudaPositiva")
    public String ayudaPositiva(){
        return "ayuda/ayudaPositiva";
    }
    @GetMapping("correcto")
    public String correcto(){
        return "ayuda/correcto";
    }

    @GetMapping("enviarEmailTest")
    public String enviarEmailTest(){
        test.getTest().hacerEmail(test.getResultado(),test.getPtosTotales(),test.getEmail());
        return "redirect:/testPsicologico/index?correo";
    }
    @GetMapping("enviarSmsTest")
    public String enviarSmsTest(){
        return "redirect:/testPsicologico/index?sms";
    }
}