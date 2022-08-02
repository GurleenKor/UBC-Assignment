package org.ubc.core;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class GistRequestModal {
    @SerializedName("description")
    String description;
    @SerializedName("public")
    Boolean publicVisibility;
    @SerializedName("files")
    Map<String, Content> files;


    public GistRequestModal(String description, Boolean publicVisibility, Map<String, Content> files) {
        this.description = description;
        this.publicVisibility = publicVisibility;
        this.files = files;
    }



    static class Content {
        @SerializedName("content")
        String content;
        public Content(String content) {
            this.content = content;
        }
    }
}
