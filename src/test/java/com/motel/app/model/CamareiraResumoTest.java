package com.motel.app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CamareiraResumoTest {
    @Test
    public void testEqualsAndHashCode() {
        CamareiraResumo a = new CamareiraResumo("Maria",1,2,3,4,5,6,7.5);
        CamareiraResumo b = new CamareiraResumo("Maria",1,2,3,4,5,6,7.5);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testToStringContainsName() {
        CamareiraResumo a = new CamareiraResumo("Ana",0,0,0,0,0,0,0.0);
        assertTrue(a.toString().contains("Ana"));
    }
}
