package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Object[] array = new Object[]{1, 2, 3, 4};
        Object[] array = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5, 6, new Object[]{7, 8, new Object[]{9, 10}}}}, 11};
        new App().transform(array);
        Object[] result = new App().transformArray(array);
        System.out.println("RESULTADO");
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public Object[] transform(Object[] objects) {               // O(n²)
        if(objects == null) return new Object[]{};
        Object[] result = this.transformRecursive(objects);
        return result;
    }

    public Object[] transformRecursive(Object[] objects) {          // O(n²)
        Object[] result = new Object[objects.length];
        int current = 0; 
        for(int i = 0; i < objects.length; i++) {                   // O(n²)
            if(objects[i] instanceof Object[] iObjects) {
                Object[] value = this.transformRecursive(iObjects);
                result = resize(result, value, current);            // O(n)
                current = result.length - 1;
            } else {
                result[current] = objects[i];
                current++;
            }
        }
        return result;
    }

    // Método para cambiar el tamaño del arreglo
    public Object[] resize(Object[] result, Object[] value, int current) {      // O(n)
        Object[] newResult = new Object[value.length + current];
        int concat = 0;
        for(int i = 0; i < current; i++) {
            newResult[i] = result[i];
            concat++;
        }

        for(int i = 0; i < value.length; i++) {
            newResult[concat] = value[i];
            concat++;
        }
        return newResult;
    }

    /*
     * IMPLEMENTACIÓN USANDO LIST
     */
    public Object[] transformArray(Object[] objects) {
        if(objects == null) return new Object[]{};
        List<Object> result = this.transformRecursiveArray(objects);
        return result.toArray();
    }

    public List<Object> transformRecursiveArray(Object[] objects) {          // O(n)
        List<Object> result = new ArrayList<>();
        for(int i = 0; i < objects.length; i++) {                           // O(n)
            if(objects[i] instanceof Object[] iObjects) {
                List<Object> value = this.transformRecursiveArray(iObjects);
                result.addAll(value);
                continue;
            }
            result.add(objects[i]);
        }
        return result;
    }
}