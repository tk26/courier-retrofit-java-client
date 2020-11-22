package services;

import models.Event;
import models.Events;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class EventsService {
    private final EventsInterface eventsInterface;

    public EventsService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.courier.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eventsInterface = retrofit.create(EventsInterface.class);
    }

    public Events getEvents(
            String token
    ) throws IOException {
        return eventsInterface.getEvents(
                "Bearer " + token
        ).execute().body();
    }

    public Event getEvent(
            String eventId,
            String token
    ) throws IOException {
        return eventsInterface.getEvent(
                eventId,
                "Bearer " + token
        ).execute().body();
    }

    public Event putEvent(
            String eventId,
            Event event,
            String token
    ) throws IOException {
        return eventsInterface.putEvent(
                eventId,
                event,
                "Bearer " + token
        ).execute().body();
    }
}
