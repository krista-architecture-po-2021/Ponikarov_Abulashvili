import facade.FacadeController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/user")
public class UserRest {
    FacadeController facadeController;

    @GET
    @Path("/categories")
    @Produces(APPLICATION_JSON)
    public Response getAllCategories() {
        facadeController = new FacadeController(null, null, null);

        return Response.ok(facadeController.getCategoryList()).build();
    }

    @GET
    @Path("/news_titles")
    @Produces(APPLICATION_JSON)
    public Response getNewsTitles() {
        facadeController = new FacadeController(null, null, null);

        return Response.ok(facadeController.getNewsTitleList()).build();
    }
}
