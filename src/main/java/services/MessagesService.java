package services;

import models.Message;
import models.MessageHistory;
import models.Messages;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class MessagesService {
    private final MessagesInterface messagesInterface;

    public MessagesService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.courier.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        messagesInterface = retrofit.create(MessagesInterface.class);
    }

    public Messages getMessages(
            String cursor,
            String event,
            String list,
            String messageId,
            String notification,
            String recipient,
            String token
    ) throws IOException {
        return messagesInterface.getMessages(
                cursor,
                event,
                list,
                messageId,
                notification,
                recipient,
                "Bearer " + token
        ).execute().body();
    }

    public Message getMessage(
            String messageId,
            String token
    ) throws IOException {
        return messagesInterface.getMessage(
                messageId,
                "Bearer " + token
        ).execute().body();
    }

    public MessageHistory getMessageHistory(
            String messageId,
            String type,
            String token
    ) throws IOException {
        return messagesInterface.getMessageHistory(
                messageId,
                type,
                "Bearer " + token
        ).execute().body();
    }
}
