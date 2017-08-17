package com.t3h.basemvp.module;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dungtx on 8/15/17.
 */

public class ItemStudent {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("birth")
    private String birth;

    @SerializedName("address")
    private String address;

    public ItemStudent(String id, String name, String birth, String address) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
