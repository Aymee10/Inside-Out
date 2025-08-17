package dev.aymee.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.aymee.dto.AddMomentDTO;
import dev.aymee.model.Emotion;
import dev.aymee.service.MomentService;
import dev.aymee.view.AddMomentView;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsString;

public class MomentControllerTest {
   private AddMomentView addMomentView;
   private MomentService momentService;
   private MomentController controller= new MomentController(addMomentView, momentService);
    
  @BeforeEach
    void setUp() {
        addMomentView = mock(AddMomentView.class);
        momentService = mock(MomentService.class);
        controller = new MomentController(addMomentView, momentService);
    }
     @Test
    void addMoment_SuccessMessage() {
       
        when(addMomentView.askTitle()).thenReturn("Paseo");
        when(addMomentView.askDescription()).thenReturn("Un dia de paseo");
        when(addMomentView.askEmotion()).thenReturn(Emotion.ALEGRIA);
        when(addMomentView.askDate()).thenReturn(LocalDate.of(2023, 11, 25));

        String result = controller.addMoment();
       
        assertThat(result, is("Momento añadido correctamente"));

        verify(momentService, times(1)).addMoment(any(AddMomentDTO.class));
    }

    @Test
    void addMoment_ErrorMessage() {
        
        when(addMomentView.askTitle()).thenReturn("ErrorTest");
        when(addMomentView.askDescription()).thenReturn("Fallo");
        when(addMomentView.askEmotion()).thenReturn(Emotion.IRA);
        when(addMomentView.askDate()).thenReturn(LocalDate.of(2023, 11, 25));

        doThrow(new RuntimeException("Fallo")).when(momentService).addMoment(any());

        String result = controller.addMoment();

        assertThat(result, containsString("Error al añadir el momento: Fallo"));
    }

}
