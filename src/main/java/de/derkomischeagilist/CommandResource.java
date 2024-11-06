package de.derkomischeagilist;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/command")
public class CommandResource {

    private final Adventure adventure;

    @Inject
    AdventureService adventureService;

    public CommandResource(AdventureService adventureService) {
        this.adventureService = adventureService;
        adventure = adventureService.getAdventure();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @QueryParam("command")
    public String game(@QueryParam("command") String command) {
        String commandResult = adventure.tell(command).replace("\r\n", "<br />").replace("\n", "<br />");
        var description =  "<h1>you are in the " + adventure.whereAreWe().toLowerCase() + "</h1>" + commandResult;

        return String.format("{\"gameInfo\": \"%s\", \"actions\": \"%s\"}", description, adventure.getActions());
    }
}
