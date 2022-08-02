package org.ubc.core;


import org.ubc.utilities.ResponseCodes;
import com.google.gson.Gson;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class GistAPITest {
    private OkHttpClient client;
    private Request request;
    private MediaType mediaType;
    private Gson gson;

    @BeforeClass
    public void setUp() {
        client = new OkHttpClient().newBuilder().build();
        mediaType = MediaType.parse("application/json");
        gson= new Gson();
    }

    @Test
    public void verifyGistCreation() {
        String requestString = gson.toJson(new RequestBodyFactory().createRequestBody());
        Request request = NetworkFactory.generateRequest(requestString);
        verifyResponse(request, client, ResponseCodes.REQUEST_SUCCESS);

    }

    @Test
    public void verifyGistCreationWithOutFiles() {

        String requestString = gson.toJson(new RequestBodyFactory().createRequestBodyWithOutFiles());
        Request request=NetworkFactory.generateRequest(requestString);
        verifyResponse(request,client,ResponseCodes.REQUEST_INVALID);

    }

    @Test
    public void verifyGistCreationWithOutUserAgent() {
        OkHttpClient client = this.client.newBuilder()
                .addNetworkInterceptor(chain -> {
                    Request request = chain.request().newBuilder().removeHeader("User-Agent").build();
                    return chain.proceed(request);
                })
                .build();

        String requestString = gson.toJson(new RequestBodyFactory().createRequestBodyWithOutFiles());
        Request request=NetworkFactory.generateRequest(requestString);
        verifyResponse(request,client,ResponseCodes.REQUEST_FORBIDDEN);

    }


    private void verifyResponse(Request request, OkHttpClient client, ResponseCodes status) {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            Assert.assertEquals(response.code(), status.code);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }


    }

}

