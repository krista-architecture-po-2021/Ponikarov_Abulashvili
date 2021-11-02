import dto.NewsDTO;
import facade.FacadeController;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/author")
public class AuthorRest {
    FacadeController facadeController;

    @GET
    @Path("/news")
    @Produces(APPLICATION_JSON)
    public Response getAllNews() {
        facadeController = new FacadeController(null, null, null);

        return Response.ok(facadeController.getNewsList()).build();
    }

    @GET
    @Path("/news/{author_name}")
    @Produces(APPLICATION_JSON)
    public Response getAuthorNews(@PathParam("author_name") String authorName) {
        facadeController = new FacadeController(null, List.of(authorName), null);

        return Response.ok(facadeController.getNewsList()).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public void addNews(@Valid NewsDTO newsDTO) {
        facadeController = new FacadeController(null, null, null);
        facadeController.addNews(newsDTO);
    }

    @DELETE
    @Path("/{id}")
    public void deleteNews(@PathParam("id") int deleteNewsId) {
        facadeController = new FacadeController(null, null, null);
        facadeController.deleteNews(deleteNewsId);
    }
}
