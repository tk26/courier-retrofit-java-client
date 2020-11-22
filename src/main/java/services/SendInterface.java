package services;

import models.SendListRequestBody;
import models.SendRequestBody;
import models.SendResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SendInterface {
    // TODO support Idempotent Requests
    @POST("/send")
    Call<SendResponseBody> send(
            @Body SendRequestBody sendRequestBody,
            @Header("Authorization") String authorization
    );

    @POST("/send/list")
    Call<SendResponseBody> sendToList(
            @Body SendListRequestBody sendListRequestBody,
            @Header("Authorization") String authorization
    );
}
