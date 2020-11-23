package services;

import models.Preference;
import models.PreferenceUpdateResponseBody;
import models.Preferences;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class PreferencesService {
    private final PreferencesInterface preferencesInterface;

    public PreferencesService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.courier.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        preferencesInterface = retrofit.create(PreferencesInterface.class);
    }

    public Preferences getPreferences(
            String token
    ) throws IOException {
        return preferencesInterface.getPreferences(
                "Bearer " + token
        ).execute().body();
    }

    public Preference getPreference(
            String recipientId,
            String token
    ) throws IOException {
        return preferencesInterface.getPreference(
                recipientId,
                "Bearer " + token
        ).execute().body();
    }

    public PreferenceUpdateResponseBody putPreference(
            String recipientId,
            Preference preference,
            String token
    ) throws IOException {
        return preferencesInterface.putPreference(
                recipientId,
                preference,
                "Bearer " + token
        ).execute().body();
    }
}
