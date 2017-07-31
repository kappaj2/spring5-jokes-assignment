package za.co.ajk.spring5.jokes.demo.services;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokesServiceImpl implements JokesService {
    
    private final ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();
    
    @Override
    public String retrieveRandomJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
