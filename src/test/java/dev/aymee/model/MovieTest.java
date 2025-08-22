package dev.aymee.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTest {
    private Movie movie;
    @BeforeEach
    void setUp() {
        movie = new Movie(
                "tt0133093",
                "The Matrix",
                Arrays.asList("Action", "Sci-Fi"),
                Emotion.ALEGRIA,
                1999,
                LocalDate.of(2025, 8, 21)
        );
    }
     @Test
    void testGetters() {
        assertThat(movie.getIdImdb(), is("tt0133093"));
        assertThat(movie.getTitle(), is("The Matrix"));
        assertThat(movie.getGenres(), contains("Action", "Sci-Fi"));
        assertThat(movie.getEmotion(), is("ALEGRIA"));
        assertThat(movie.getReleaseYear(), is(1999));
        assertThat(movie.getCreationDate(), is(LocalDate.of(2025, 8, 21)));
    }
@Test
    void testSetters() {
        movie.setIdImdb("tt0242653");
        movie.setTitle("Spider-Man 2");
        movie.setGenres(Arrays.asList("Action", "Adventure"));
        movie.setEmotion(Emotion.NOSTALGIA);
        movie.setReleaseYear(2004);
        movie.setCreationDate(LocalDate.of(2025, 8, 22));

        assertThat(movie.getIdImdb(), is("tt0242653"));
        assertThat(movie.getTitle(), is("Spider-Man 2"));
        assertThat(movie.getGenres(), contains("Action", "Adventure"));
        assertThat(movie.getEmotion(), is("NOSTALGIA"));
        assertThat(movie.getReleaseYear(), is(2004));
        assertThat(movie.getCreationDate(), is(LocalDate.of(2025, 8, 22)));
    }
}
