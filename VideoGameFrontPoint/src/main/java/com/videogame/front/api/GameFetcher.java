/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.videogame.front.api;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.videogame.front.game.entity.Game;
import com.videogame.front.game.entity.ResponseContext;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.hc.client5.http.fluent.Request;
/**
 *
 * @author manana
 */

public class GameFetcher {
    final static private String GAME_RS = "http://localhost:8080/VideogameAPI/rs/games/";
    
    public ResponseContext getAllGames(){
        String results;
        try {
            results = Request.get(GAME_RS + "getAll")
                    .execute() 
                    .returnContent()
                    .asString(StandardCharsets.UTF_8);
            JsonObject resultsJson = JsonParser.parseString(results)
                   .getAsJsonObject();
            Type dataType = new TypeToken<ResponseContext>(){}.getType();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            return gson.fromJson(resultsJson,dataType);
            } catch (IOException ex) {
                System.getLogger(GameFetcher.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                return null;
            }
    }
}
