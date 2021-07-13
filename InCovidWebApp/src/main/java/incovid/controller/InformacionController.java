package incovid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("informacion")
public class InformacionController {

    @GetMapping("index")
    public String index(){
        return "informacion/index";
    }
}
