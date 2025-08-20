package dev.aymee.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private InputStream originalIn;

    private MainController mainController;

    @BeforeEach
    public void setUp() {
        originalIn = System.in;
        System.setOut(new PrintStream(outContent));

    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

     @Test
    public void shouldShowMenuAndExitWhenOptionFiveIsChosen() {
        String simulatedInput = "6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        mainController=new MainController();
        mainController.start();
        String output = outContent.toString();
        assertTrue(output.contains("1. Añadir momento"));
        assertTrue(output.contains("6. Salir"));
        assertTrue(output.contains("Hasta la próxima!!!"));

    }

     @Test
    public void shouldCreateAMomentWhenOptionOneIsChosen() {

        String simulatedInput = "1\n" +
                        "Un día en el parque de atracciones\n" + 
                        "Moment description\n" + 
                        "1\n" + 
                        "01/05/2024\n" + 
                        "1\n" +
                        "6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        mainController = new MainController();

        mainController.start();

        String output = outContent.toString();

        assertTrue(output.contains("1. Añadir momento"));
        assertTrue(output.contains("Ingrese la descripción del momento"));
    }
    
}