
package com.toryang.sampledemo.model.entities.usbox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {

    @SerializedName("box")
    @Expose
    private Integer box;
    @SerializedName("new")
    @Expose
    private Boolean _new;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("subject")
    @Expose
    private Subject_ subject;

    /**
     * 
     * @return
     *     The box
     */
    public Integer getBox() {
        return box;
    }

    /**
     * 
     * @param box
     *     The box
     */
    public void setBox(Integer box) {
        this.box = box;
    }

    /**
     * 
     * @return
     *     The _new
     */
    public Boolean getNew() {
        return _new;
    }

    /**
     * 
     * @param _new
     *     The new
     */
    public void setNew(Boolean _new) {
        this._new = _new;
    }

    /**
     * 
     * @return
     *     The rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 
     * @param rank
     *     The rank
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 
     * @return
     *     The subject
     */
    public Subject_ getSubject() {
        return subject;
    }

    /**
     * 
     * @param subject
     *     The subject
     */
    public void setSubject(Subject_ subject) {
        this.subject = subject;
    }

}
