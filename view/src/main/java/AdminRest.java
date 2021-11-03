import facade.FacadeController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/admin")
public class AdminRest {
    FacadeController facadeController;

    @GET
    @Path("/categories")
    @Produces(APPLICATION_JSON)
    public Response getAllCategories() {
        facadeController = new FacadeController(null, null, null);

        return Response.ok(facadeController.getCategoryList()).build();
    }

    @DELETE
    @Path("/categories/{id}")
    @Produces(APPLICATION_JSON)
    public void deleteCategories(@PathParam("id") int deleteCategoryId) {
        facadeController = new FacadeController(null, null, null);
        facadeController.deleteCategory(deleteCategoryId);
    }

    @GET
    @Path("/news")
    @Produces(APPLICATION_JSON)
    public Response getAllNews() {
        facadeController = new FacadeController(null, null, null);

        return Response.ok(facadeController.getNewsList()).build();
    }

    @DELETE
    @Path("/news/{id}")
    public void deleteNews(@PathParam("id") int deleteNewsId) {
        facadeController = new FacadeController(null, null, null);
        facadeController.deleteNews(deleteNewsId);
    }
}
