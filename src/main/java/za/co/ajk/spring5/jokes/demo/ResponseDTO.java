package za.co.ajk.spring5.jokes.demo;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
    
    private String joke;
    
    public String getJoke() {
        return joke;
    }
    
    public void setJoke(String joke) {
        this.joke = joke;
    }
}
