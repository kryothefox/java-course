package com.gregor.videogameapi.dto;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.gregor.videogameapi.entity.ResponseContext;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;


import org.apache.hc.client5.http.fluent.Request;
public class RawgClient {
    private static final String API_URL = "https://api.rawg.io/api/";
    private static final String API_KEY = "9d8576dd55634467b393f27ca677f94d";
    public static final String BASE_URI = API_URL + "games?key=" + API_KEY + "&page=1&page_size=40";
    
    private static final System.Logger LOG = System.getLogger(RawgClient.class.getName());
    
    public ResponseContext getGames(String uri){
        try{
            
           String results = Request.get(uri)
                   .execute()
                   .returnContent()
                   .asString(StandardCharsets.UTF_8); 
            JsonObject resultsJson = JsonParser.parseString(results)
                   .getAsJsonObject();
            Type dataType = new TypeToken<ResponseContext>(){}.getType();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            return gson.fromJson(resultsJson,dataType);
        } catch (Exception e) {
            LOG.log(System.Logger.Level.INFO,"No se pudo conectar a la api. ",e);
        }
        return null;
    }
}
