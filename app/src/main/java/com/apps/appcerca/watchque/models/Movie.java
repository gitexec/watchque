package com.apps.appcerca.watchque.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by wington on 1/7/17.
 */

public class Movie {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",poster);
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    String title;
    String poster;
    String overview;

    public Movie(JSONObject moviesObject) throws JSONException{
        this.title = moviesObject.getString("original_title");
        this.poster = moviesObject.getString("poster_path");
        this.overview = moviesObject.getString("overview");

    }

    public static ArrayList<Movie> toJSONArrayList(JSONArray moviesArray){
        ArrayList<Movie> toArrayList = new ArrayList<Movie>();
        for(int i = 0; i<moviesArray.length(); i++){
            try {
                toArrayList.add(new Movie(moviesArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return toArrayList;
    }
}
