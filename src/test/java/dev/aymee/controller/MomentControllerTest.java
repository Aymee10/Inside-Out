package dev.aymee.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.aymee.dto.AddMomentDTO;
import dev.aymee.model.Emotion;
import dev.aymee.service.MomentService;
import dev.aymee.view.AddMomentView;
import dev.aymee.view.DeleteMomentView;
import dev.aymee.view.FilterByCategoryView;
import dev.aymee.view.FilterByEmotionView;
import dev.aymee.view.FilterByDateView;
import dev.aymee.view.FilterMomentsListView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;

public class MomentControllerTest {
   private AddMomentView addMomentView;
   private MomentService momentService;
   private DeleteMomentView delete;
   private FilterMomentsListView filter;
   private FilterByDateView filterByDateView;
   private FilterByEmotionView filterByEmotionView;
   private FilterByCategoryView filterByCategoryView;
   private MomentController controller= new MomentController(addMomentView, momentService,delete,filter,filterByEmotionView,filterByDateView, filterByCategoryView);
    
  @BeforeEach
    void setUp() {
        addMomentView = mock(AddMomentView.class);
        momentService = mock(MomentService.class);
        delete=mock(DeleteMomentView.class);
        filter=mock(FilterMomentsListView.class);
     

        controller = new MomentController(addMomentView, momentService,delete,filter, filterByEmotionView,filterByDateView);
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
@Test
void listMomentsTest(){
    when(momentService.listMoments()).thenReturn(Arrays.asList( "1-Ocurrió el: 20/05/2023. Título: Viaje. Descripción: Un viaje inolvidable. Emoción: Alegria"));
    var result=controller.listMoments();
    assertThat(result, hasSize(1));
    assertThat(result.get(0), containsString("Un viaje inolvidable"));
}
@Test
void deleteMomentTest(){
    when(delete.delete()).thenReturn(1);
    when(momentService.deleteMoment(1)).thenReturn("Momento vivido eliminado correctamente");
    var result=controller.deleteMoment();
    assertThat(result, is("Momento vivido eliminado correctamente"));
}
@Test
void filterMoments_ByEmotion() {
    filterByEmotionView = mock(FilterByEmotionView.class);
    filterByDateView = mock(FilterByDateView.class);
    controller = new MomentController(addMomentView, momentService, delete, filter, filterByEmotionView, filterByDateView);

    when(filter.filterMoments()).thenReturn(1); 
    when(filterByEmotionView.filterEmotion()).thenReturn(Emotion.ALEGRIA);
    when(momentService.filterByEmotion(Emotion.ALEGRIA))
            .thenReturn(Arrays.asList("1-Ocurrió el: 20/05/2023. Título: Viaje. Descripción: Día feliz. Emoción: Alegria"));

    var result = controller.filterMoments();
    assertThat(result, hasSize(1));
    assertThat(result.get(0), containsString("Día feliz"));
    verify(momentService, times(1)).filterByEmotion(Emotion.ALEGRIA);        

}
@Test
void filterMoments_InvalidOption() {
    filterByEmotionView = mock(FilterByEmotionView.class);
    filterByDateView = mock(FilterByDateView.class);
    controller = new MomentController(addMomentView, momentService, delete, filter, filterByEmotionView, filterByDateView);

    when(filter.filterMoments()).thenReturn(3); 

    var result = controller.filterMoments();

    assertThat(result, hasSize(1));
    assertThat(result.get(0), is("Opción no válida"));
   }
}
