package com.t3h.basemvp.module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dungtx on 8/3/17.
 */

public class ItemMovie {

    @SerializedName("paper")
    private String paper;

    @SerializedName("total_papes")
    private String total_papes;

    @SerializedName("totla_resuls")
    private String total_resuls;

    @SerializedName("results")
    private List<Results> resultses;

    public String getPaper() {
        return paper;
    }

    public String getTotal_papes() {
        return total_papes;
    }

    public String getTotal_resuls() {
        return total_resuls;
    }

    public List<Results> getResultses() {
        return resultses;
    }

    public static class Results{
        @SerializedName("id")
        private String id;

        @SerializedName("title")
        private String title;

        @SerializedName("vote_count")
        private String voteCount;

        @SerializedName("poster_path")
        private String posterPath;

        @SerializedName("overview")
        private String overview;

        public String getOverview() {
            return overview;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getVoteCount() {
            return voteCount;
        }

        public String getPosterPath() {
            return posterPath;
        }
    }
}
