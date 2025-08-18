package dev.aymee.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.aymee.model.Emotion;
import dev.aymee.model.Moment;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

public class MomentsRepositoryTest {
    private MomentsRepository repository;

     @BeforeEach
    void setUp() {
        repository = new MomentsRepository();
    }

    @Test
    void addMoment_shouldStoreMomentInList() {
        Moment moment = new Moment(1, "Prueba Titulo1", "Prueba Descripción1", Emotion.ALEGRIA, LocalDate.of(2020, 1, 1));
        repository.addMoment(moment);

        List<Moment> moments = repository.findAll();
        assertThat(moments.size(), equalTo(1));
        assertThat(moments.get(0), equalTo(moment));
    }

    @Test
    void findAll_shouldReturnEmptyListWhenNoMomentsAdded() {
        List<Moment> moments = repository.findAll();
        assertThat(moments.size(), equalTo(0));
    }

    @Test
    void findAll_shouldReturnAllStoredMoments() {
        Moment moment1 = new Moment(1, "Prueba Titulo1", "Prueba Descripción1", Emotion.ALEGRIA, LocalDate.of(2020, 1, 1));
        Moment moment2 = new Moment(2, "Prueba Titulo2", "Prueba Descripción2", Emotion.NOSTALGIA, LocalDate.of(2025, 1, 1));

        repository.addMoment(moment1);
        repository.addMoment(moment2);

        List<Moment> moments = repository.findAll();
        assertThat(moments.size(), equalTo(2));
        assertThat(moments.get(0), equalTo(moment1));
        assertThat(moments.get(1), equalTo(moment2));
    }
    @Test
    void shouldDeleteExistingMoment(){
        Moment moment1 = new Moment(1, "Prueba Titulo1", "Prueba Descripción1", Emotion.ALEGRIA, LocalDate.of(2020, 1, 1));
        Moment moment2 = new Moment(2, "Prueba Titulo2", "Prueba Descripción2", Emotion.NOSTALGIA, LocalDate.of(2025, 1, 1));
         repository.addMoment(moment1);
         repository.addMoment(moment2);
         
         assertThat(repository.deleteMoment(1), is(true));
         assertThat(repository.findAll().size(), is(1));
    }
    @Test
    void shouldDeleteNonExistingMoment(){
        Moment moment1 = new Moment(1, "Prueba Titulo1", "Prueba Descripción1", Emotion.ALEGRIA, LocalDate.of(2020, 1, 1));
        Moment moment2 = new Moment(2, "Prueba Titulo2", "Prueba Descripción2", Emotion.NOSTALGIA, LocalDate.of(2025, 1, 1));
         repository.addMoment(moment1);
         repository.addMoment(moment2);
         
         assertThat(repository.deleteMoment(5), is(false));
         assertThat(repository.findAll().size(), is(2));



    }

}
