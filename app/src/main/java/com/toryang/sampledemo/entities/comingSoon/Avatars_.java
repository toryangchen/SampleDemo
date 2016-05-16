
package com.toryang.sampledemo.entities.comingSoon;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avatars_ {

    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("medium")
    @Expose
    private String medium;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Avatars_() {
    }

    /**
     * 
     * @param small
     * @param medium
     * @param large
     */
    public Avatars_(String small, String large, String medium) {
        this.small = small;
        this.large = large;
        this.medium = medium;
    }

    /**
     * 
     * @return
     *     The small
     */
    public String getSmall() {
        return small;
    }

    /**
     * 
     * @param small
     *     The small
     */
    public void setSmall(String small) {
        this.small = small;
    }

    /**
     * 
     * @return
     *     The large
     */
    public String getLarge() {
        return large;
    }

    /**
     * 
     * @param large
     *     The large
     */
    public void setLarge(String large) {
        this.large = large;
    }

    /**
     * 
     * @return
     *     The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * 
     * @param medium
     *     The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

}
