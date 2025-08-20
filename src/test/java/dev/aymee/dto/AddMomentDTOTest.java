package dev.aymee.dto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dev.aymee.model.Emotion;

public class AddMomentDTOTest {
    @Test
    public void AddMomentDto(){
        LocalDate date=LocalDate.of(2021,2 ,2 );
        AddMomentDTO dto=new AddMomentDTO("Momento Prueba1", "Descripcion prueba 1", Emotion.ANSIEDAD, date,true);

        assertThat("Momento Prueba1", equalTo(dto.getTitle()));
        assertThat("Descripcion prueba 1", equalTo(dto.getDescription()));
        assertThat(Emotion.ANSIEDAD,equalTo(dto.getEmotion()));
        assertThat(date,equalTo(dto.getMomentDate()));

    }
}
