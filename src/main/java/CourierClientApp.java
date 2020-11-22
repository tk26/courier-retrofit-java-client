import com.google.gson.Gson;
import models.*;
import services.EventsService;
import services.MessagesService;
import services.SendService;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class CourierClientApp {
    public static void main(String[] args) throws IOException {
        final String COURIER_API_KEY = "COURIER_API_KEY";

        /*
        Messages API
         */
        Message message = new MessagesService()
                .getMessage(
                        "1-5fbad98b-2e42ffd617b7119e2b4d36a0",
                        System.getenv(COURIER_API_KEY)
                );
        System.out.println(message);

        Messages messages = new MessagesService()
                .getMessages(null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        System.getenv(COURIER_API_KEY)
                );
        System.out.println(messages);

        MessageHistory messageHistory = new MessagesService()
                .getMessageHistory(
                        "1-5fbad293-457f43e1020a851720d2b09f",
                        null,
                        System.getenv(COURIER_API_KEY)
                );
        System.out.println(messageHistory);

        /*
        Send API
         */
        SendRequestBody sendRequestBody = new SendRequestBody();
        sendRequestBody.setEvent("TEST_WELCOME");
        sendRequestBody.setRecipient(UUID.randomUUID().toString());
        HashMap<String, String> profile = new HashMap<String, String>();
        profile.put("phone_number", "+16147793748");
        sendRequestBody.setProfile(new Gson().toJson(profile));

        SendResponseBody sendResponseBody1 = new SendService()
                .send(sendRequestBody, System.getenv(COURIER_API_KEY));
        System.out.println(sendResponseBody1);

        SendListRequestBody sendListRequestBody = new SendListRequestBody();
        sendListRequestBody.setList("tejas.list.test");
        sendListRequestBody.setEvent("TEST_WELCOME");

        SendResponseBody sendResponseBody2 = new SendService()
                .sendToList(sendListRequestBody, System.getenv(COURIER_API_KEY));
        System.out.println(sendResponseBody2);

        /*
        Events API
         */
        Event event = new EventsService()
                .getEvent("TEST_WELCOME", System.getenv(COURIER_API_KEY));
        System.out.println(event);

        Events events = new EventsService()
                .getEvents(System.getenv(COURIER_API_KEY));
        System.out.println(events);

        Event newEventRequest = new Event();
        newEventRequest.setId("JRV6HF5HD6MHE6HD12B4B74YPEWP");
        newEventRequest.setType("notification");
        Event newEventResponse = new EventsService()
                .putEvent("WELCOME_BACK", newEventRequest, System.getenv(COURIER_API_KEY));
        System.out.println(newEventResponse);
    }
}