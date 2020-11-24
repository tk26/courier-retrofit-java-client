package services;

import models.ListUpdateBody;
import models.PureLists;
import models.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface ListsInterface {
    @GET("/lists")
    Call<PureLists> getLists(
            @Query("cursor") String cursor,
            @Query("pattern") String pattern,
            @Header("Authorization") String authorization
    );

    @GET("/lists/{listId}")
    Call<List> getList(
            @Path("listId") String listId,
            @Header("Authorization") String authorization
    );

    @PUT("/lists/{listId}")
    Call<Void> putList(
            @Path("listId") String listId,
            @Body ListUpdateBody listUpdateBody,
            @Header("Authorization") String authorization
    );

    @DELETE("/lists/{listId}")
    Call<Void> deleteList(
            @Path("listId") String listId,
            @Header("Authorization") String authorization
    );
}
