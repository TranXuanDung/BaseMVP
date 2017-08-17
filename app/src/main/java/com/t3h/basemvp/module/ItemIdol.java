package com.t3h.basemvp.module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dungtx on 8/10/17.
 */

public class ItemIdol {

    @SerializedName("count")
    private String count;

    @SerializedName("total")
    private String total;

    @SerializedName("result")
    private List<Result> results;

    public String getCount() {
        return count;
    }

    public String getTotal() {
        return total;
    }

    public List<Result> getResults() {
        return results;
    }

    public static class Result{

        @SerializedName("id")
        private String id;

        @SerializedName("name")
        private String name;

        @SerializedName("japanName")
        private String japanName;

        @SerializedName("bust")
        private String bust;

        @SerializedName("waist")
        private String waist;

        @SerializedName("hip")
        private String hip;

        @SerializedName("height")
        private String height;

        @SerializedName("imageUrl")
        private String imageUrl;

        public String getImageUrl() {
            return imageUrl;
        }

        @SerializedName("siteUrl")
        private String siteUrl;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getJapanName() {
            return japanName;
        }

        public String getBust() {
            return bust;
        }

        public String getWaist() {
            return waist;
        }

        public String getHip() {
            return hip;
        }

        public String getHeight() {
            return height;
        }

        public String getSiteUrl() {
            return siteUrl;
        }
    }
}
