package dev.aymee.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.aymee.dto.AddMomentDTO;
import dev.aymee.model.Emotion;
import dev.aymee.repository.MomentsRepository;

public class MomenteServiceTest {

    MomentsRepository repo=new MomentsRepository();
    AddMomentDTO dto=new AddMomentDTO("Paseo", "Un dia de paseo", Emotion.IRA, LocalDate.of(2020, 10, 10));
    MomentService service = new MomentService(repo);

   @Test
   void addMomentTest(){
       service.addMoment(dto);
       assertThat(repo.findAll().size(), is(1));
       assertThat(repo.findAll().get(0).getTitle(), is("Paseo"));
       assertThat(repo.findAll().get(0).getDescription(), is("Un dia de paseo"));
       assertThat(repo.findAll().get(0).getModifiedDate(),is(LocalDate.now()));

   }
    @Test
    void listMomentsTest(){
     service.addMoment(dto);
     var result = service.listMoments();
      assertThat(result.size(), is(1));
      String expected = "1-Ocurrió el: 10/10/2020. Título: Paseo. Descripción: Un dia de paseo. Emoción: Ira";
      assertThat(result.get(0), is(expected));
    }
    @Test
    void deleteMoment_Success() {
        service.addMoment(dto);

        String result = service.deleteMoment(1);

        assertThat(result, is("Momento vivido eliminado correctamente"));
        assertThat(repo.findAll().size(), is(0));
    }
    @Test
    void filterByEmotionTest() {
        service.addMoment(dto); 
        AddMomentDTO dto2 = new AddMomentDTO("Viaje", "Un viaje feliz", Emotion.ALEGRIA, LocalDate.of(2021, 5, 20));
        service.addMoment(dto2);

        var result = service.filterByEmotion(Emotion.ALEGRIA);

        assertThat(result, hasSize(1));
        assertThat(result.get(0), containsString("Viaje"));
        assertThat(result.get(0), containsString("Emoción: Alegria"));
    }

    @Test
    void filterByDateTest() {
        service.addMoment(dto); 
        AddMomentDTO dto2 = new AddMomentDTO("Estudio", "Día de estudios", Emotion.ANSIEDAD, LocalDate.of(2022, 1, 1));
        service.addMoment(dto2);

        var result = service.filterByDate(LocalDate.of(2020, 10, 10));

        assertThat(result, hasSize(1));
        assertThat(result.get(0), containsString("Paseo"));
        assertThat(result.get(0), containsString("10/10/2020"));
    }

}
 