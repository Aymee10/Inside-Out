package dev.aymee.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListMomentsViewTest {

    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
           System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
         System.setOut(originalSystemOut);
    }

    @Test
    public void testListMoments() {
        List<String> testMoments = Arrays.asList("Momento 1", "Momento 2", "Momento 3");
        ListMomentsView view = new ListMomentsView();
        
        view.ListMoments(testMoments);
    String ls = System.lineSeparator();
    String expectedOutput = "Lista de momentos vividos:"+ ls +
                            "1. Momento 1" + ls +
                            "2. Momento 2" + ls +
                            "3. Momento 3" + ls +
                            ls;

    assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testListMomentsEmptyList() {
        List<String> emptyList = Arrays.asList();
        ListMomentsView view = new ListMomentsView();
        String ls = System.lineSeparator();
        view.ListMoments(emptyList);

        String expectedOutput = "Lista de momentos vividos:" + ls + ls;

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}