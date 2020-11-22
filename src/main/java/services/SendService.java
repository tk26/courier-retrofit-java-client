package services;

import models.SendListRequestBody;
import models.SendRequestBody;
import models.SendResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class SendService {
    private final SendInterface sendInterface;

    public SendService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.courier.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        sendInterface = retrofit.create(SendInterface.class);
    }

    public SendResponseBody send(
            SendRequestBody sendRequestBody,
            String token
    ) throws IOException {
        return sendInterface.send(
                sendRequestBody,
                "Bearer " + token
        ).execute().body();
    }

    public SendResponseBody sendToList(
            SendListRequestBody sendListRequestBody,
            String token
    ) throws IOException {
        return sendInterface.sendToList(
                sendListRequestBody,
                "Bearer " + token
        ).execute().body();
    }
}
