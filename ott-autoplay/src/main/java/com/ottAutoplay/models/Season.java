package com.ottAutoplay.models;

import java.util.LinkedList;

public class Season {
    String title;
    int seasonNumber;
    LinkedList<Episode> episodeList;

    public Season(String title, int seasonNumber, LinkedList<Episode> episodeList) {
        this.title = title;
        this.episodeList = episodeList;
        this.seasonNumber = seasonNumber;
    }

    public Season() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(LinkedList<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
