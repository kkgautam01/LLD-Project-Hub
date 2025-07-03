package com.ottAutoplay;


import com.ottAutoplay.service.AutoPlayService;
import com.ottAutoplay.service.ContentManageService;
import com.ottAutoplay.models.Episode;
import com.ottAutoplay.models.Season;

import java.util.LinkedList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        ContentManageService series = new ContentManageService();

        LinkedList<Episode> episodesList = getEpisodesList();

        series.addSeason(4,new Season("Season 4",4, episodesList));
        series.addSeason(5,new Season("Season 5",5, episodesList));
        series.addSeason(2,new Season("Season 2",2,  episodesList));
        series.addSeason(1,new Season("Season 1",1, episodesList));
        series.addSeason(3,new Season("Season 3",3, episodesList));

        AutoPlayService autoPlayService = new AutoPlayService(series.getAllSeasons());

        System.out.println("---Standard auto Play---");
        playSeries(autoPlayService);

        System.out.println("---Season Auto Play---");
        playSeriesFromEpisode(autoPlayService,3);

        System.out.println("---Resume Auto Play---");

        resumeSeries(autoPlayService, 4,3);
    }

    public static LinkedList<Episode> getEpisodesList(){

        LinkedList<Episode> list = new LinkedList<>();
        for(int i = 1; i <=4; i++){
            list.add(new Episode("Episode "+i, i));
        }

        return list;
    }

    public static void playSeries(AutoPlayService autoPlayService){
        autoPlayService.standardAutoPlay();
    }

    public static void playSeriesFromEpisode(AutoPlayService autoPlayService, int seasonNumber){
        autoPlayService.autoPlaySeason(seasonNumber);
    }

    public static void resumeSeries(AutoPlayService autoPlayService, int seasonNumber, int episodeNumber){
        autoPlayService.autoPlayResume(seasonNumber,episodeNumber);
    }
}