package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutorController {
    
    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @RequestMapping("/autoren")
    public String getAutoren(Model model)
    {
        model.addAttribute("autoren", this.autorRepository.findAll());
        return "autoren/liste";
    }
}
