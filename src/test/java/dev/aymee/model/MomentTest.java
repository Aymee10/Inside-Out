package dev.aymee.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class MomentTest {
    @Test
    public void MomentConstructorTest(){
    int id = 1;
    String title = "Momento de prueba";
    String description = "Prueba";
    Emotion emotion = Emotion.ALEGRIA;
    LocalDate momentDate = LocalDate.of(2025, 5, 15);
    boolean isGood=true;

    Moment moment = new Moment(id, title, description, emotion, momentDate,isGood);

    assertEquals(id, moment.getId());
    assertEquals(title, moment.getTitle());
    assertEquals(description, moment.getDescription());
    assertEquals(emotion, moment.getEmotion());
    assertEquals(momentDate, moment.getMomentDate());
    assertNotNull(moment.getCreatedDate());
    assertNotNull(moment.getModifiedDate());
    assertEquals(LocalDate.now(), moment.getCreatedDate());
    assertEquals(LocalDate.now(), moment.getModifiedDate());
    }

    @Test
   public void MomentSetterTest(){
    Moment moment = new Moment(2, "Momento2", "Prueba de momento 2", Emotion.ANSIEDAD, LocalDate.of(2024, 11, 11),true);
    moment.setTitle("Título nuevo");
    moment.setDescription("Descripción 2 nueva");
    moment.setEmotion(Emotion.NOSTALGIA);
    moment.setMomentDate(LocalDate.of(2025, 1, 1));

    assertEquals("Título nuevo", moment.getTitle());
    assertEquals("Descripción 2 nueva", moment.getDescription());
    assertEquals(Emotion.NOSTALGIA, moment.getEmotion());
    assertEquals(LocalDate.of(2025, 1, 1), moment.getMomentDate());
   }
}
