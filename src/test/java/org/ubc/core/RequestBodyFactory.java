package org.ubc.core;

import com.google.gson.Gson;
import org.ubc.entity.GistRequestModal;

import java.util.HashMap;
import java.util.Map;

public class RequestBodyFactory {
    private  Gson gson;
    public static final String DUMMY_FILE_NAME="ReadMe.md";
    public static final String DUMMY_DESCRIPTION_CONTENT="UBC IRP Student QA!";
    public static final String DUMMY_DESCRIPTION="UBC GIST";
    public static final boolean DUMMY_PUBLIC_VISIBILITY=true;

    public GistRequestModal createRequestBody()
    {

        Map<String, GistRequestModal.Content> files= new HashMap<>();
            files.put(DUMMY_FILE_NAME,new GistRequestModal.Content(DUMMY_DESCRIPTION_CONTENT));
            return createGistRequestModal(files);

    }

    public GistRequestModal createRequestBodyWithOutFiles()
    {
        return createGistRequestModal(null);
    }

     public GistRequestModal createGistRequestModal(Map<String, GistRequestModal.Content> files)
    {
        return(new GistRequestModal(DUMMY_DESCRIPTION,DUMMY_PUBLIC_VISIBILITY, files));
    }

}
