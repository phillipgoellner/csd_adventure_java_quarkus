package de.derkomischeagilist;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/game")
public class GameResource {

    private final Adventure adventure;

    @Inject
    AdventureService adventureService;

    public GameResource(AdventureService adventureService) {
        this.adventureService = adventureService;
        adventure = adventureService.getAdventure();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String game() {
        return "<html><head>"+
                "<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"   integrity=\"sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=\" crossorigin=\"anonymous\"></script>"+
                "<script src=\"/game.js\"></script></head><body><h1>Hello Gamers</h1>" +
                "<div id=\"gameInfo\"><p>Welcome to our new Adventure!<br>"+
                adventure.Begin()+
                "</p></div><form id=\"commandForm\" ><input id=\"command\" type=\"text\"/></form>"+
                "</body></html>";
    }
}