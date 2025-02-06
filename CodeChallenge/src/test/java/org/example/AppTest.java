package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class AppTest {

    @Test
    public void testApp() {
        assertTrue( true );
    }

    @Test
    public void testAnagramaTrue() {
        App app = new App();
        boolean result = app.checkAnagrama("espada", "pesada");
        assertTrue(result);
    }

    @Test
    public void testAnagramaFalse() {
        App app = new App();
        boolean result = app.checkAnagrama("hola", "colas");
        assertFalse(result);
    }

    @Test
    public void testAnagramaNull() {
        App app = new App();
        boolean result1 = app.checkAnagrama(null, "cola");
        assertFalse(result1);

        boolean result2 = app.checkAnagrama("amor", null);
        assertFalse(result2);

        boolean result3 = app.checkAnagrama(null, null);
        assertFalse(result3);

    }


}
