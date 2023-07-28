package com.bytebank.test;

public class TestWrappers {

    public static void main(String[] args) {
        Double numero_double = 33.0; 
        boolean verdadero = true;
        
        Double numero_double2 = Double.valueOf(33); 
        System.out.println(numero_double2);
        
        String numero_string = "43";
        Double string_to_double = Double.valueOf(numero_string);
        Integer string_to_integer = Integer.valueOf(numero_string);
        
        System.out.println(string_to_double);
        System.out.println(string_to_integer);
        
        Number numero = Integer.valueOf(5);
        Double num_double_primitivo = numero.doubleValue();
        System.out.println(num_double_primitivo);
        
    }

}
