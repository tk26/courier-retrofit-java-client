package services;

import models.Preference;
import models.PreferenceUpdateResponseBody;
import models.Preferences;
import retrofit2.Call;
import retrofit2.http.*;

public interface PreferencesInterface {
    @GET("/preferences")
    Call<Preferences> getPreferences(
            @Header("Authorization") String authorization
    );

    @GET("/preferences/{recipientId}")
    Call<Preference> getPreference(
            @Path("recipientId") String recipientId,
            @Header("Authorization") String authorization
    );

    @PUT("/preferences/{recipientId}")
    Call<PreferenceUpdateResponseBody> putPreference(
            @Path("recipientId") String recipientId,
            @Body Preference preference,
            @Header("Authorization") String authorization
    );
}
