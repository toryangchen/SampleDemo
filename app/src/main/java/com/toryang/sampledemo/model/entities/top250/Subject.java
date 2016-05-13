
package com.toryang.sampledemo.model.entities.top250;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("genres")
    @Expose
    private List<String> genres = new ArrayList<String>();
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("casts")
    @Expose
    private List<Cast> casts = new ArrayList<Cast>();
    @SerializedName("collect_count")
    @Expose
    private Integer collectCount;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("directors")
    @Expose
    private List<Director> directors = new ArrayList<Director>();
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Subject() {
    }

    /**
     * 
     * @param id
     * @param collectCount
     * @param title
     * @param genres
     * @param alt
     * @param subtype
     * @param originalTitle
     * @param images
     * @param year
     * @param casts
     * @param rating
     * @param directors
     */
    public Subject(Rating rating, List<String> genres, String title, List<Cast> casts, Integer collectCount, String originalTitle, String subtype, List<Director> directors, String year, Images images, String alt, String id) {
        this.rating = rating;
        this.genres = genres;
        this.title = title;
        this.casts = casts;
        this.collectCount = collectCount;
        this.originalTitle = originalTitle;
        this.subtype = subtype;
        this.directors = directors;
        this.year = year;
        this.images = images;
        this.alt = alt;
        this.id = id;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * 
     * @param genres
     *     The genres
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
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

    /**
     * 
     * @return
     *     The casts
     */
    public List<Cast> getCasts() {
        return casts;
    }

    /**
     * 
     * @param casts
     *     The casts
     */
    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    /**
     * 
     * @return
     *     The collectCount
     */
    public Integer getCollectCount() {
        return collectCount;
    }

    /**
     * 
     * @param collectCount
     *     The collect_count
     */
    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    /**
     * 
     * @return
     *     The originalTitle
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * 
     * @param originalTitle
     *     The original_title
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * 
     * @return
     *     The subtype
     */
    public String getSubtype() {
        return subtype;
    }

    /**
     * 
     * @param subtype
     *     The subtype
     */
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    /**
     * 
     * @return
     *     The directors
     */
    public List<Director> getDirectors() {
        return directors;
    }

    /**
     * 
     * @param directors
     *     The directors
     */
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    /**
     * 
     * @return
     *     The year
     */
    public String getYear() {
        return year;
    }

    /**
     * 
     * @param year
     *     The year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 
     * @return
     *     The images
     */
    public Images getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(Images images) {
        this.images = images;
    }

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
