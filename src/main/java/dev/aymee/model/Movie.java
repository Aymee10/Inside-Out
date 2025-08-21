package dev.aymee.model;

import java.util.List;
public class Movie {
    private String idImdb;
    private String title;
    private List<String> genres;
    private Emotion emotion;
    private int releaseYear;
    public Movie(String idImdb, String title, List<String> genres, Emotion emotion, int releaseYear) {
        this.idImdb = idImdb;
        this.title = title;
        this.genres = genres;
        this.emotion = emotion;
        this.releaseYear = releaseYear;
    }
    public String getIdImdb() {
        return idImdb;
    }
    public String getTitle() {
        return title;
    }
    public List<String> getGenres() {
        return genres;
    }
    public String getEmotion() {
        return emotion.name();
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setIdImdb(String idImdb) {
        this.idImdb = idImdb;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    
}

