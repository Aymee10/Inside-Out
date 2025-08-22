package dev.aymee.dto;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.nullValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dev.aymee.dao.*;

public class ApiMoviesDAOTest {

    private InterfaceApiMoviesDAO caller;

    @BeforeEach
    void setUp() {
        this.caller = new ApiMoviesDAO();
    }

    @Test
    void testGetCall() {
        String imdbId = "tt2250912";
        String body = caller.getMovie(imdbId);
        assertThat(body, not(nullValue()));
        assertThat(body, containsString("error_code"));
        assertThat(body, containsString("Spider-Man: Homecoming"));
    }

    @Test
    void testGetCall_ShouldReturnAnExceptionIfMovieDoesNotExist() {
        String body = caller.getMovie("");
        assertThat(body, containsString("pass 'q' OR 'tt' as a query string parameter"));
    }

    

}