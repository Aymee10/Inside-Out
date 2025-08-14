package dev.aymee.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class EmotionTest {
    @Test
    public void testEnumValuesExist() {
        
        assertEquals(10, Emotion.values().length);
        assertNotNull(Emotion.ALEGRIA);
        assertNotNull(Emotion.TRISTEZA);
        assertNotNull(Emotion.IRA);
        assertNotNull(Emotion.ASCO);
        assertNotNull(Emotion.MIEDO);
        assertNotNull(Emotion.ANSIEDAD);
        assertNotNull(Emotion.ENVIDIA);
        assertNotNull(Emotion.VERGUENZA);
        assertNotNull(Emotion.ABURRIMIENTO);
        assertNotNull(Emotion.NOSTALGIA);
    }
}
