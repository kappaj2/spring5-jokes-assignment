package za.co.ajk.spring5.jokes.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.ajk.spring5.jokes.demo.ResponseDTO;
import za.co.ajk.spring5.jokes.demo.services.JokesService;

@RestController
public class JokesRestController {
    
    private JokesService jokesService;
    
    @Autowired
    public JokesRestController(JokesService jokesService) {
        this.jokesService = jokesService;
    }
    
    @GetMapping(value = "/getJoke", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJoke() {
        final HttpHeaders httpHeaders= new HttpHeaders();
        String joke = jokesService.retrieveRandomJoke();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>("{\"Joke\": \""+joke+"\"}", httpHeaders, HttpStatus.OK);
        
    }
    
    @GetMapping(value="getJoke1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getJoke1(){
        String joke = jokesService.retrieveRandomJoke();
        HttpStatus httpStatus = HttpStatus.OK;
        ResponseDTO dto = new ResponseDTO();
        dto.setJoke(joke);
        return new ResponseEntity<ResponseDTO>(dto,httpStatus);
    }
    
}
