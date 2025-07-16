package com.gregor.videogameapi.resources;

import com.gregor.videogameapi.db.GameDAO;
import com.gregor.videogameapi.dto.GameDTO;
import com.gregor.videogameapi.models.Games;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("games")
@Produces(MediaType.APPLICATION_JSON)
public class GameService {

    /*RawgClient rawgclient = new RawgClient();

    @GET
    public Response getAllGames() {
        try {
            GameDataImporter gdi = new GameDataImporter();
            gdi.insertData();
            return Response
                    .ok("Todo okey")
                    .build();
        } catch (Exception ex) {
            System.getLogger(GameService.class.getName())
                    .log(System.Logger.Level.ERROR, "Lo que sea", ex);
            return Response.status(500)
                    .entity("Ha habido un error")
                    .build();
        }
    }*/
    
    @GET
    @Path("/getById/{id}") //PathParam
    public Response getGame(@PathParam("id") int id) {
        Games game;
        try (GameDAO gdao = new GameDAO()) {
            game = gdao.findById(id);
        }
        
        if (game != null) {
            GameDTO gdto = GameDTO.fromEntity(game);
            return Response
                    .ok(gdto)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No se ha encontrado ningún juego con ese id.")
                    .build();
        }
    }
    
    @GET
    @Path("/getByIds") //MatrixParam
    public Response getGames(@MatrixParam("ids") int... ids) {
        List<Games> games = new ArrayList();
        try (GameDAO gdao = new GameDAO()) {
            for(int id: ids) {
                Games game = gdao.findById(id);
                if (game != null) {
                    games.add(game);
                }
            }
        }
        
        if (!games.isEmpty()) {
            List<GameDTO> gamedtos = games.stream()
                    .map(g -> GameDTO.fromEntity(g))
                    .collect(Collectors.toList());
            return Response
                    .ok(gamedtos)
                    .build();
        } else {
            return Response
                .status(Response.Status.NOT_FOUND)
                .entity("No se ha encontrado ningún juego con esos ids.")
                .build();
            
        }
    }
    
    @GET
    @Path("/getByName/{name}") //PathParam
    public Response getGame(@PathParam("name") String name) {
        Games game;
        try (GameDAO gdao = new GameDAO()) {
            game = gdao.findByName(name);
        }
        
        if (game != null) {
            GameDTO gdto = GameDTO.fromEntity(game);
            return Response
                    .ok(gdto)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("No se ha encontrado ningún juego con ese nombre.")
                    .build();
        }
    }
    
    @GET
    @Path("/getAll") //QueryParam
    public Response getAllGames(@QueryParam("start") @DefaultValue("0") int start, @QueryParam("size") @DefaultValue("40") int size) {
        try (GameDAO gdao = new GameDAO()) {
            List<Games> games = gdao.findRange(start, size);
            List<GameDTO> gamedtos = games.stream()
                    .map(g -> GameDTO.fromEntity(g))
                    .collect(Collectors.toList());
            return Response
                    .ok(gamedtos)
                    .build();
        } catch (Exception ex) {
            return Response
                .status(Response.Status.NOT_FOUND)
                .entity("No se han podido obtener todos los juegos. " + ex.getMessage())
                .build();
        }
    }
    
    @PUT
    @Path("/add") //QueryParam
    public Response createGame(@QueryParam("name") String name, @QueryParam("slug") @DefaultValue("rawg") String slug) {
        Games game = new Games();
        game.setName(name);
        game.setSlug(slug);
        
        boolean isCreated;
        try (GameDAO gdao = new GameDAO()) {
            isCreated = gdao.create(game);
        }
        
        if (isCreated) {
            GameDTO gdto = GameDTO.fromEntity(game);
            return Response
                    .ok(gdto)
                    .build();
        } else {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("No se ha podido insertar un nuevo juego en la base de datos.")
                    .build();
        }
    }
    
    @PUT
    @Path("/update") //QueryParam
    public Response updateGame(@QueryParam("id") int id, @QueryParam("name") String name,
            @QueryParam("slug") @DefaultValue("rawg") String slug) {
        try (GameDAO gdao = new GameDAO()) {
            Games game = gdao.findById(id);
            game.setName(name);
            game.setSlug(slug);
            gdao.update(game);
            GameDTO gdto = GameDTO.fromEntity(game);
            return Response
                    .ok(gdto)
                    .build();
        } catch(Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("No se ha podido actualizar el juego en la base de datos. " + ex.getMessage())
                    .build();
        }
    }
    
    @DELETE
    @Path("/remove/{id}") //PathParam
    public Response removeGame(@PathParam("id") int id) {
        try (GameDAO gdao = new GameDAO()) {
            gdao.delete(id);
            return Response
                    .ok("Se ha eliminado el juego con éxito.")
                    .build();
        } catch(Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("No se ha podido eliminar el juego en la base de datos. " + ex.getMessage())
                    .build();
        }
    }

}
