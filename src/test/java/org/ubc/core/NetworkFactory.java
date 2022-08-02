package org.ubc.core;

import org.ubc.utilities.Constants;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class NetworkFactory {

    public NetworkFactory()
    {

    }


    public static Request generateRequest(String requestJsonString) {
        RequestBody body = RequestBody.create(requestJsonString, MediaType.parse("application/json"));
        return new Request.Builder()
                .url(Constants.URL)
                .post(body)
                .addHeader("Accept", "application/vnd.github+json")
                .addHeader("Authorization", "token " + Constants.TOKEN)
                .build();
    }
}
