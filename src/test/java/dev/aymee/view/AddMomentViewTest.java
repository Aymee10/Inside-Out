package dev.aymee.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.aymee.model.Emotion;

import java.util.Scanner;

public class AddMomentViewTest {
    private AddMomentView view;
    private InputStream input;

    @BeforeEach
    public void setUp(){
        String simulatedInput = ""; 
        input = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(input);
        view = new AddMomentView(scanner);
    }
    private void setSimulatedInput(String simulatedinput) {
        input = new ByteArrayInputStream(simulatedinput.getBytes());
        view = new AddMomentView(new Scanner(input));
    } 

    @Test
    public void testAskTitle(){
       setSimulatedInput("Titulo de prueba\n");
        String title = view.askTitle();
        assertEquals("Titulo de prueba", title);   
    }
    @Test
    public void testAskDescription() {
        setSimulatedInput("Descripcion de prueba\n");
        String description = view.askDescription();
        assertEquals("Descripcion de prueba", description);
    }
    @Test
    public void testAskEmotionWithInvalidThenValidInput() {
        setSimulatedInput("abc\n99\n2\n");
        Emotion emotion = view.askEmotion();
        assertEquals(Emotion.TRISTEZA, emotion);
    }
}
