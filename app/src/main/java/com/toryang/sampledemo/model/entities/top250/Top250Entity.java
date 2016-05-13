
package com.toryang.sampledemo.model.entities.top250;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Top250Entity {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("subjects")
    @Expose
    private List<Subject> subjects = new ArrayList<Subject>();
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Top250Entity() {
    }

    /**
     * 
     * @param total
     * @param title
     * @param count
     * @param subjects
     * @param start
     */
    public Top250Entity(Integer count, Integer start, Integer total, List<Subject> subjects, String title) {
        this.count = count;
        this.start = start;
        this.total = total;
        this.subjects = subjects;
        this.title = title;
    }

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The start
     */
    public Integer getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * 
     * @param subjects
     *     The subjects
     */
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
