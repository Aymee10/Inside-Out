package dev.aymee.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        String simulatedInput = "Titulo de prueba\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(in);

        AddMomentView view = new AddMomentView(scanner);
        String title = view.askTitle();
        assertEquals("Titulo de prueba", title);
        scanner.close();
   
    }

}
