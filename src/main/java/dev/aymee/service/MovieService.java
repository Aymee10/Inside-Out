package dev.aymee.service;

import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dev.aymee.dao.ApiMoviesDAO;
import dev.aymee.dto.MovieDTO;

public class MovieService {
    
    private ApiMoviesDAO movieDAO;

    public MovieService(ApiMoviesDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    public JsonObject getMovieInfo(String imdbId) {
        
        String movieData = movieDAO.getMovie(imdbId);

        StringReader reader = new StringReader(movieData);
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

        return jsonObject;
    }

    public MovieDTO getMovieInfoAndMapToDTO(String imdbId) {
        
        Gson gson = new GsonBuilder().create();
        String movieData = movieDAO.getMovie(imdbId);

        MovieDTO movieDTO = gson.fromJson(movieData, MovieDTO.class);

        return movieDTO;
    }

}
