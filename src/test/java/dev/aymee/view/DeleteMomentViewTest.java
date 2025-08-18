package dev.aymee.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteMomentViewTest {
   private DeleteMomentView deleteView;
   private InputStream input;

   @BeforeEach
    public void setUp(){
        String simulatedInput = ""; 
        input = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(input);
        deleteView = new DeleteMomentView(scanner);
    }
    private void setSimulatedInput(String simulatedinput) {
        input = new ByteArrayInputStream(simulatedinput.getBytes());
        deleteView = new DeleteMomentView(new Scanner(input));
    } 
   
    @Test
    void deleteWithCorrectInput(){
     setSimulatedInput("2\n");
     assertThat(deleteView.delete(),is(2));
    }
    @Test
     void deleteWithIncorrectInput(){
     setSimulatedInput("A\n5\n");
     
     assertThat(deleteView.delete(),is(5));
    }
}
