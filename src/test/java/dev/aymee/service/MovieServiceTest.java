package dev.aymee.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import dev.aymee.dao.*;
import dev.aymee.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonObject;

public class MovieServiceTest {

    private MovieService movieService;

    @BeforeEach
    void setUp() {
     this.movieService = new MovieService(new ApiMoviesDAO());
    }

    @Test
    void testMappingResponseBody_ShouldReturnJsonObject() {
        
        String imdbId = "tt2250912";
        JsonObject json = movieService.getMovieInfo(imdbId);

        assertThat(json.get("imdbId").getAsString(), is(equalTo(imdbId)));
        assertThat(json.get("short").getAsJsonObject().get("name").getAsString(), is(equalTo("Spider-Man: Homecoming")));
        assertThat(json.get("short").getAsJsonObject().get("url").getAsString(), is(equalTo("https://www.imdb.com/title/tt2250912/")));
        assertThat(json.get("short").getAsJsonObject().get("image").getAsString(), is(equalTo("https://m.media-amazon.com/images/M/MV5BODY2MTAzOTQ4M15BMl5BanBnXkFtZTgwNzg5MTE0MjI@._V1_.jpg")));
        assertThat(json.get("short").getAsJsonObject().get("genre").getAsJsonArray().size(), is(equalTo(3)));
    }

    @Test
    void testMappingResponseBody_ShouldReturnAMovieDTO() {
        String imdbId = "tt2250912";
        MovieDTO movieInfo = movieService.getMovieInfoAndMapToDTO(imdbId);

        assertThat(movieInfo.getImdbId(), is(equalTo(imdbId)));
        assertThat(movieInfo.getShortInfo().getName(), is(equalTo("Spider-Man: Homecoming")));
        assertThat(movieInfo.getShortInfo().getUrl(), is(equalTo("https://www.imdb.com/title/tt2250912/")));
        assertThat(movieInfo.getShortInfo().getImage(), is(equalTo("https://m.media-amazon.com/images/M/MV5BODY2MTAzOTQ4M15BMl5BanBnXkFtZTgwNzg5MTE0MjI@._V1_.jpg")));
        assertThat(movieInfo.getShortInfo().getGenre().length, is(equalTo(3)));
        assertThat(movieInfo.getShortInfo().getGenre()[0], is(equalTo("Action")));
    }

}
