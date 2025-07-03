package com.ottAutoplay.service;

import com.ottAutoplay.models.Episode;
import com.ottAutoplay.models.Season;

import java.util.LinkedList;
import java.util.TreeMap;

public class AutoPlayService {

    TreeMap<Integer, Season> series = new TreeMap<>();

    public AutoPlayService(TreeMap<Integer, Season> series) {
        this.series = series;
    }

    public void standardAutoPlay(){
        for(Season season : series.values()){
            LinkedList<Episode> episodeList = season.getEpisodeList();
            System.out.println("- "+season.getTitle());
            playEpisodes(episodeList,1);
        }
    }

    public void playEpisodes(LinkedList<Episode> episodeList, int startEpisode){
        for(int i = startEpisode; i <= episodeList.size(); i++ ) {
            Episode episode = episodeList.get(i-1); // index starts from 0.
            System.out.println(episode.getTitle());
        }
    }

    public void autoPlaySeason(int seasonNumber){
        for(Season season : series.tailMap(seasonNumber).values()){
            LinkedList<Episode> episodeList = season.getEpisodeList();
            System.out.println("- "+season.getTitle());
            playEpisodes(episodeList,1);
        }
    }

    public void autoPlayResume(int seasonNumber, int episode){
        for(Season season : series.tailMap(seasonNumber).values()){
            LinkedList<Episode> episodeList = season.getEpisodeList();
            System.out.println("- "+season.getTitle());
            if(seasonNumber == season.getSeasonNumber())
                playEpisodes(episodeList,episode);
            else
                playEpisodes(episodeList,1);

        }
    }

}
