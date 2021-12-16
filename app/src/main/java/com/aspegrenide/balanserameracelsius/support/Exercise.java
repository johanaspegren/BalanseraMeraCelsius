package com.aspegrenide.balanserameracelsius.support;

import java.io.Serializable;

public class Exercise implements Serializable {

    private String name;
    private String description;
    private String makeItHarder;
    private String movieclip;
    private String videoUri;
    private String videoStorageReference;

    public Exercise() {
    }

    public Exercise(String name) {
        this.name = name;
    }

    public Exercise(String name, String description, String makeItHarder, String movieclip,
                    String videoUri, String stringStorageReference) {
        this.name = name;
        this.description = description;
        this.makeItHarder = makeItHarder;
        this.movieclip = movieclip;
        this.videoUri = videoUri;
        this.videoStorageReference = stringStorageReference;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", makeItHarder=" + makeItHarder +
                ", movieclip='" + movieclip + '\'' +
                ", videoUri='" + videoUri + '\'' +
                ", stringStorageReference='" + videoStorageReference + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMakeItHarder() {
        return makeItHarder;
    }

    public void setMakeItHarder(String makeItHarder) {
        this.makeItHarder = makeItHarder;
    }

    public String getMovieclip() {
        return movieclip;
    }

    public void setMovieclip(String movieclip) {
        this.movieclip = movieclip;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public String getVideoStorageReference() {
        return videoStorageReference;
    }

    public void setVideoStorageReference(String videoStorageReference) {
        this.videoStorageReference = videoStorageReference;
    }
}
