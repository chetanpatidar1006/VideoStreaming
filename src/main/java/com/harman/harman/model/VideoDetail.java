package com.harman.harman.model;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity()
@Table(name="VideoDetail")
public class VideoDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer Id;

    String title;

    String synopsis;

    String director;

    String castName;

    String yearOfRelease;

    String genre;

    Integer runningTime;

    Boolean deListed;

    Integer impressions ;

    Integer views ;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCastName() {
        return castName;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }

    public Boolean getDeListed() {
        return deListed;
    }

    public void setDeListed(Boolean deListed) {
        this.deListed = deListed;
    }

    public Integer getImpressions() {
        return impressions;
    }

    public void setImpressions(Integer impressions) {
        this.impressions = impressions;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "VideoDetail{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", sirector='" + director + '\'' +
                ", castName='" + castName + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                ", deListed=" + deListed +
                ", impressions=" + impressions +
                ", views=" + views +
                '}';
    }
}
