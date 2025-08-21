package dev.aymee.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterMomentViewTest {
    @Test
    void testFilterByEmotion() {
        String input = "1\n"; 
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        FilterMomentsListView view = new FilterMomentsListView(scanner);
        int result = view.filterMoments();

        assertEquals(1, result);
    }
@Test
    void testFilterByFecha() {
        String input = "2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        FilterMomentsListView view = new FilterMomentsListView(scanner);
        int result = view.filterMoments();

        assertEquals(2, result);
    }
}
