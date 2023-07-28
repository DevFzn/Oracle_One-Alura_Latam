package com.bytebank.test;

public class TestEjemPoliSuma {
    public static void main(String[] args) {
        suma(1,2,3,4);
        suma("a","b","c","d");
    }

    private static void suma(int...argumentos) {
        int resultado = 0;
        for (int arg : argumentos) {
            resultado+=arg;
        }
        System.out.println("Total: "+resultado);
    }
    
    private static void suma(String...argumentos) {
        String resultado = "";
        for (String arg : argumentos) {
            resultado+=arg;
        }
        System.out.println("Total: "+resultado);
    }
}
