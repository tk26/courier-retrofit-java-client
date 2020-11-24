package services;

import models.PatchRequestBody;
import models.Profile;
import models.ProfileLists;
import models.UpdateResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ProfilesService {
    private final ProfilesInterface profilesInterface;

    public ProfilesService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.courier.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        profilesInterface = retrofit.create(ProfilesInterface.class);
    }

    public Profile getProfile(
            String recipientId,
            String token
    ) throws IOException {
        return profilesInterface.getProfile(
                recipientId,
                "Bearer " + token
        ).execute().body();
    }

    public UpdateResponseBody postProfile(
            String recipientId,
            Profile profile,
            String token
    ) throws IOException {
        return profilesInterface.postProfile(
                recipientId,
                profile,
                "Bearer " + token
        ).execute().body();
    }

    public UpdateResponseBody patchProfile(
            String recipientId,
            PatchRequestBody patchRequestBody,
            String token
    ) throws IOException {
        return profilesInterface.patchProfile(
                recipientId,
                patchRequestBody,
                "Bearer " + token
        ).execute().body();
    }

    public UpdateResponseBody putProfile(
            String recipientId,
            Profile profile,
            String token
    ) throws IOException {
        return profilesInterface.putProfile(
                recipientId,
                profile,
                "Bearer " + token
        ).execute().body();
    }

    public ProfileLists getProfileLists(
            String recipientId,
            String cursor,
            String token
    ) throws IOException {
        return profilesInterface.getProfileLists(
                recipientId,
                cursor,
                "Bearer " + token
        ).execute().body();
    }
}
