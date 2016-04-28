
package com.toryang.sampledemo.model.entities.usbox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Cast {

    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("avatars")
    @Expose
    private Avatars avatars;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * 
     * @return
     *     The alt
     */
    public String getAlt() {
        return alt;
    }

    /**
     * 
     * @param alt
     *     The alt
     */
    public void setAlt(String alt) {
        this.alt = alt;
    }

    /**
     * 
     * @return
     *     The avatars
     */
    public Avatars getAvatars() {
        return avatars;
    }

    /**
     * 
     * @param avatars
     *     The avatars
     */
    public void setAvatars(Avatars avatars) {
        this.avatars = avatars;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

}
