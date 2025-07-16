package com.videogame.front.userlogic;

import com.videogame.front.api.GameFetcher;
import com.videogame.front.game.entity.Game;
import com.videogame.front.user.entity.User;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "gamesHandler")
@SessionScoped
public class GamesHandler implements Serializable {

    private Game currentGame;
    private User currentUser;

    public GamesHandler() {
        this.currentGame = new Game();
        this.currentUser = new User();
    }
    
    
    
    public List<Game> getGames(){
        GameFetcher gf = new GameFetcher();
        System.out.println(gf.getAllGames().getResults());
        return null;
    }
    

    
}
