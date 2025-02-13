package com.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    void shouldTransformObjectToArray() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{"3", "4"}};
        Object[] result = app.transform(array);
        Object[] expected = new Object[]{1, 2, "3", "4"};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldHaveSameArray() {
        App app = new App();
        Object[] array = new Object[]{1, 2, 3, 4};
        Object[] result = app.transform(array);
        assertNotNull(result);
        assertArrayEquals(array, result);
    }

    @Test
    void shouldTransformeMultipleArrays() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{"3", "4", new Object[]{5, 6}}};
        Object[] result = app.transform(array);
        Object[] expected = new Object[]{1, 2, "3", "4", 5, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldTransformeMultipleArraysWithLetters() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{"a", "b", new Object[]{5, 6}}};
        Object[] result = app.transform(array);
        Object[] expected = new Object[]{1, 2, "a", "b", 5, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldTransformeMultipleArrays2() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5, 6, new Object[]{7, 8, new Object[]{9, 10}}}}};
        Object[] result = app.transform(array);
        Object[] expected = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldReturnEmptyArray() {
        App app = new App();
        Object[] array = null;
        Object[] result = app.transform(array);
        Object[] expected = new Object[]{};
        assertArrayEquals(expected, result);
    }

    // TESTS HACIENDO USO DE LIST
    @Test
    void shouldReturnEmptyArrayWithList() {
        App app = new App();
        Object[] array = null;
        Object[] result = app.transformArray(array);
        Object[] expected = new Object[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldTransformObjectToArrayWithList() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{"3", "4"}};
        Object[] result = app.transformArray(array);
        Object[] expected = new Object[]{1, 2, "3", "4"};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldHaveSameArrayWithList() {
        App app = new App();
        Object[] array = new Object[]{1, 2, 3, 4};
        Object[] result = app.transformArray(array);
        assertNotNull(result);
        assertArrayEquals(array, result);
    }

    @Test
    void shouldTransformeMultipleArraysWithList() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{"3", "4", new Object[]{5, 6}}};
        Object[] result = app.transformArray(array);
        Object[] expected = new Object[]{1, 2, "3", "4", 5, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldTransformeMultipleArraysWithLettersWithList() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{"a", "b", new Object[]{5, 6}}};
        Object[] result = app.transformArray(array);
        Object[] expected = new Object[]{1, 2, "a", "b", 5, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldTransformeMultipleArrays2WithList() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5, 6, new Object[]{7, 8, new Object[]{9, 10}}}}};
        Object[] result = app.transformArray(array);
        Object[] expected = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldTransformeMultipleArrays3WithList() {
        App app = new App();
        Object[] array = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5, 6, new Object[]{7, 8, new Object[]{9, 10}}}}, 11};
        Object[] result = app.transformArray(array);
        Object[] expected = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(expected, result);
    }
}
