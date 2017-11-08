package com.vibhav2k17.android.vibhav2k17;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by prajwal on 24/10/17.
 */

public class Contact {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("created_time")
    @Expose
    private String created_time;

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("link")
    @Expose
    private String link;



    @SerializedName("full_picture")
    @Expose
    private String full_picture;


    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The name
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The email
     */
    public String getCreated_time() {
        return created_time;
    }

    /**
     * @param created_time The email
     */
    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    /**
     * @return The address
     */

    /**
     * @return The profilePic
     */
    public String getFull_picture() {
        return full_picture;
    }

    /**
     * @param full_picture The profile_pic
     */
    public void setFull_picture(String full_picture) {
        this.full_picture = full_picture;
    }

    /**
     * @return The profilePic
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The profile_pic
     */
    public void setLink(String link) {
        this.link = link;
    }




}