package com.t3h.basemvp.module;

/**
 * Created by dungtx on 8/2/17.
 */

public class ItemMovieReponse {
    private String dataCode;
    private String title;

    public ItemMovieReponse(String dataCode, String title) {
        this.dataCode = dataCode;
        this.title = title;
    }

    public String getDataCode() {
        return dataCode;
    }

    public String getTitle() {
        return title;
    }
}
