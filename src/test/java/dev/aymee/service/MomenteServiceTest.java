package dev.aymee.service;

import static org.hamcrest.MatcherAssert.assertThat;
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
}
