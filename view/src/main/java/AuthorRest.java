import dto.NewsDTO;
import facade.FacadeController;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Arrays;
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
    public Response getAuthorNews(@PathParam("author_name") String authorsStr) {
        List<String> authors = Arrays.asList(authorsStr.split("\\+"));

        facadeController = new FacadeController(null, authors, null);

        return Response.ok(facadeController.getNewsList()).build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public void addNews(@Valid NewsDTO newsDTO) {
        facadeController = new FacadeController(null, null, null);
        facadeController.addNews(newsDTO);
    }

    @PUT
    @Path("/news/{id}")
    public void updateNews(@PathParam("id") int updateNewsId, @Valid NewsDTO newsDTO) {
        facadeController = new FacadeController(null, null, null);
        facadeController.updateNews(updateNewsId, newsDTO);
    }

    @DELETE
    @Path("/news/{id}")
    public void deleteNews(@PathParam("id") int deleteNewsId) {
        facadeController = new FacadeController(null, null, null);
        facadeController.deleteNews(deleteNewsId);
    }
}
