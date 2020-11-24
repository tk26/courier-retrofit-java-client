package services;

import models.List;
import models.ListUpdateBody;
import models.PureLists;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ListsService {
    private final ListsInterface listsInterface;

    public ListsService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.courier.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        listsInterface = retrofit.create(ListsInterface.class);
    }

    public PureLists getLists(
            String cursor,
            String pattern,
            String token
    ) throws IOException {
        return listsInterface.getLists(
                cursor,
                pattern,
                "Bearer " + token
        ).execute().body();
    }

    public List getList(
            String listId,
            String token
    ) throws IOException {
        return listsInterface.getList(
                listId,
                "Bearer " + token
        ).execute().body();
    }

    public void putList(
            String listId,
            ListUpdateBody listUpdateBody,
            String token
    ) throws IOException {
        listsInterface.putList(
                listId,
                listUpdateBody,
                "Bearer " + token
        ).execute();
    }

    public void deleteList(
            String listId,
            String token
    ) throws IOException {
        listsInterface.deleteList(
                listId,
                "Bearer " + token
        ).execute();
    }
}
