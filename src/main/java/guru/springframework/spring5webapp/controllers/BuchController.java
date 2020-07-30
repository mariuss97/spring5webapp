package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BuchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuchController {

    private final BuchRepository buchRepository;

    public BuchController(BuchRepository buchRepository) {
        this.buchRepository = buchRepository;
    }

    @RequestMapping("/buecher") /*Zugriff via web: localhost:8080/buecher*/
    public String getBuecher(Model model){
        model.addAttribute("buecher", buchRepository.findAll()); /*Aufruf von buecher in Template moeglich*/
        return "buecher/liste"; /*Verweis auf Pfad des Templates fuer View*/
    }
}
