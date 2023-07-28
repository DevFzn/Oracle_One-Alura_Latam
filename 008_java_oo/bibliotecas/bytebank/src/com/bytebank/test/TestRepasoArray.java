package com.bytebank.test;

import java.util.ArrayList;
import java.util.List;

public class TestRepasoArray {

    public static void main(String[] args) {
        // creación de array int
        int[] numeros = new int[10];
        
        int numero = 5;
        //Integer numero_objeto = new Integer(5); // Deprecado
        Integer numero_objeto = Integer.valueOf(5);
        List<Integer> lista = new ArrayList<Integer>();
        
        lista.add(numero); // autoboxing --> lista.add(new Integer(numero));
        
        int valorPrimitivo = numero_objeto; // unboxing
        
        //numero_objeto.intValue();
        //numero_objeto.byteValue();
        //numero_objeto.doubleValue();
        //numero_objeto.floatValue();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.BYTES);
        System.out.println(Integer.SIZE);  // bits
        System.out.println(Integer.TYPE);

        System.out.println(valorPrimitivo);
    }

}
