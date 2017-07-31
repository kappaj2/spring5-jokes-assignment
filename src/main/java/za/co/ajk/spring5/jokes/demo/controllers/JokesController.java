package za.co.ajk.spring5.jokes.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.ajk.spring5.jokes.demo.services.JokesService;

@Controller
public class JokesController {
    private static Logger log = LoggerFactory.getLogger(JokesController.class);
    
    private JokesService jokesService;
    
    /**
     * Public constructor with service injection
     * @param jokesService
     */
    @Autowired
    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }
    
    @RequestMapping({"/", ""})
    public String getJoke(Model model){
        log.info("Received request");
        model.addAttribute("joke",jokesService.retrieveRandomJoke());
        return "chucknorris";   // returns to view name chucknorris (must be valid Thymeleaf template
    }
}
