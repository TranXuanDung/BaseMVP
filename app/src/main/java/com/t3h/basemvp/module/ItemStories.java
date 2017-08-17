package com.t3h.basemvp.module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dungtx on 8/10/17.
 */

public class ItemStories {

    @SerializedName("section")
    private String section;

    @SerializedName("num_results")
    private String numResults;

    @SerializedName("results")
    private List<Results> resultses;

    public String getSection() {
        return section;
    }

    public String getNumResults() {
        return numResults;
    }

    public List<Results> getResultses() {
        return resultses;
    }

    public static class Results{

        @SerializedName("title")
        private String title;

        @SerializedName("abstract")
        private String abstracts;

        @SerializedName("multimedia")
        private Multimedia multimedias;

        public String getTitle() {
            return title;
        }

        public String getAbstracts() {
            return abstracts;
        }

        public Multimedia getMultimedias() {
            return multimedias;
        }

        public static class Multimedia{
            @SerializedName("url")
            private String url;

            public String getUrl() {
                return url;
            }
        }
    }
}
