package com.ottAutoplay.service;

import com.ottAutoplay.models.Season;

import java.util.TreeMap;


public class ContentManageService {
    TreeMap<Integer, Season> series = new TreeMap<>();

    public void addSeason(Integer seasonNumber, Season season){
        if(!series.containsKey(seasonNumber))
            series.put(seasonNumber,season);
    }

    public void removeSeason(Integer seasonsNumber){
        if(series.containsKey(seasonsNumber))
            series.remove(seasonsNumber);
    }

    public void updateSeason(Integer seasonsNumber, Season season){
        if(series.containsKey(seasonsNumber))
            series.put(seasonsNumber,season);
    }

    public TreeMap<Integer, Season> getAllSeasons(){
        return series;
    }

    public Season getSeasonByNumber(Integer seasonNumber){
        if(series.containsKey(seasonNumber))
            return series.get(seasonNumber);
        return new Season();
    }

}
