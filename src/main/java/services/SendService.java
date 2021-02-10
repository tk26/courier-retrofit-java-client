package services;

import models.SendListRequestBody;
import models.SendRequestBody;
import models.SendResponseBody;

import java.io.IOException;

public class SendService {
    private final SendInterface sendInterface;

    public SendService() {
        sendInterface = Courier.getRetrofit().create(SendInterface.class);
    }

    public SendResponseBody send(
            SendRequestBody sendRequestBody
    ) throws IOException {
        return sendInterface.send(
                sendRequestBody,
                Courier.getAuthorizationHeader()
        ).execute().body();
    }

    public SendResponseBody sendToList(
            SendListRequestBody sendListRequestBody
    ) throws IOException {
        return sendInterface.sendToList(
                sendListRequestBody,
                Courier.getAuthorizationHeader()
        ).execute().body();
    }
}
