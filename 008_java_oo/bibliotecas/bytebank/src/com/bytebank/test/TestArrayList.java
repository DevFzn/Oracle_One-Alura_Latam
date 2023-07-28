package com.bytebank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.bytebank.modelo.CuentaCorriente;
import com.bytebank.modelo.Cuenta;

public class TestArrayList {

    public static void main(String[] args) {
        //java.util.Arrays
        List<String> argumentos = Arrays.asList(args);

        //ArrayList<Cuenta> lista = new LinkedList<>();
        // Forzando el tipo de objs. que contendrá el ArrayList con '<>'
        ArrayList<Cuenta> lista = new ArrayList<>();
        Cuenta cc1 = new CuentaCorriente(33, 34);
        Cuenta cc2 = new CuentaCorriente(44, 45);
        lista.add(cc1);
        lista.add(cc2);
        
        Cuenta obtenerCuenta = lista.get(0);
        System.out.println(obtenerCuenta);
        // el método size() retorna la cantidad de elementos en la lista  
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        for (Cuenta cuenta : lista) {
            System.out.println(cuenta);
        }
        
        ArrayList lista2 = new ArrayList(26); //capacidad inicial
        lista2.add("RJ");
        lista2.add("SP");

        ArrayList nueva = new ArrayList(lista2); //creando basada en la primera lista
        System.out.println(nueva.toString());
        
        CuentaCorriente cc3 = new CuentaCorriente(33, 34);
        
        boolean contiene = lista.contains(cc1);
        if (contiene) {
            System.out.println(contiene);            
        }
        
        if (cc1.esIgual(cc3)) {
            System.out.println("Son iguales");
        }
        
        if (cc1.equals(cc3)) {
            System.out.println("Son iguales (equals override)");
        }
        
        Collection<Cuenta> lista_vector_cta = new Vector<Cuenta>();
        //Cuenta ref = lista_vector_cta.get(0);
    }
}
