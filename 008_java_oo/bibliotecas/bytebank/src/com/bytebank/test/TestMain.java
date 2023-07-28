package com.bytebank.test;

public class TestMain {

    public static void main(String[] args) {
        
        for (String string : args) {
            // imprime argumentos pasados por consola
            System.out.println(string);
        }
        
        int edad1 = 32;
        int edad2 = 18;
        int edad3 = 24;
        
        int[] edades = new int[5];
        edades[1] = edad1;
        edades[2] = edad2;
        edades[3] = edad3;
        
        for (int i = 0; i < 6; i++) {
            try {
                System.out.println(edades[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Tamaño del array: " + edades.length);
        //for (int i = 0; i < edades.length; i++) {
        //        System.out.println(edades[i]);
        //}
        for (int i : edades) {
            System.out.println(i);
        }
    }

}
