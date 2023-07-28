package com.bytebank.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import com.bytebank.modelo.Cliente;
import com.bytebank.modelo.Cuenta;
import com.bytebank.modelo.CuentaAhorro;
import com.bytebank.modelo.CuentaCorriente;

public class TestLambda {

    public static void main(String[] args) {
        Cuenta cc1 = new CuentaCorriente(22, 33);
        Cliente cliente_cc1 = new Cliente();
        cliente_cc1.setNombre("Diego");
        cc1.setTitular(cliente_cc1);
        cc1.depositar(333.1);
        
        Cuenta ca1 = new CuentaAhorro(20, 44);
        Cliente cliente_ca1 = new Cliente();
        cliente_ca1.setNombre("Cuasimodo");
        ca1.setTitular(cliente_ca1);
        ca1.depositar(444.2);
        
        Cuenta cc2 = new CuentaCorriente(23, 11);
        Cliente cliente_cc2 = new Cliente();
        cliente_cc2.setNombre("Pancracio");
        cc2.setTitular(cliente_cc2);
        cc2.depositar(333.3);
        
        Cuenta ca2 = new CuentaAhorro(21, 22);
        Cliente cliente_ca2 = new Cliente();
        cliente_ca2.setNombre("Joel");
        ca2.setTitular(cliente_ca2);
        ca2.depositar(444.4);
        
        List<Cuenta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(ca1);
        lista.add(cc2);
        lista.add(ca2);
       
        System.out.println("Antes de ordenar");
        for (Cuenta cuenta : lista) {
            System.out.println(cuenta);
        }

        // Clase anónima
        //lista.sort(new Comparator<Cuenta>() {
        //    @Override
        //    public int compare(Cuenta o1, Cuenta o2) {
        //        return (Integer.compare(o1.getNumero(), o2.getNumero()));
        //    }
        //});
        
        // Lambda
        lista.sort((Cuenta o1, Cuenta o2) ->
                Integer.compare(o1.getNumero(), o2.getNumero())
            );
        
        System.out.println("Despues de ordenar por nro. de cta.");
        for (Cuenta cuenta : lista) {
            System.out.println(cuenta);
        }

        //Collections.sort(lista, new Comparator<Cuenta>() {
        //    @Override
        //    public int compare(Cuenta o1, Cuenta o2) {
        //        return o1.getTitular().getNombre().compareTo(o2.getTitular().getNombre());
        //    }
        //});
        Collections.sort(lista, (c1, c2) -> 
                c1.getTitular().getNombre().compareTo(c2.getTitular().getNombre())
                );

        System.out.println("Despues de ordenar por nombre:");
        //for (Cuenta cuenta : lista) {
        //    System.out.println(cuenta);
        //}
        lista.forEach(cuenta -> System.out.println(cuenta));
        
        Collections.sort(lista);
        //Collections.reverse(lista);
        System.out.println("Despues de ordenar por Orden Natural:");
        for (Cuenta cuenta : lista) {
            System.out.println(cuenta);
        }
        
        // Iteradores poseen métodos nasNext() y next()
        List<String> lista_nombres = new ArrayList<>();
        lista_nombres.add("Super Mario World");
        lista_nombres.add("Super Punch-Out!!"); 
        lista_nombres.add("Super Mario Kart"); 
        lista_nombres.add("Donkey Kong"); 

        Iterator<String> it = lista_nombres.iterator();

        while(it.hasNext()) {
          System.out.println(it.next());
        }
        
        Set<String> set_nombres = new HashSet<>();
        set_nombres.add("Super Mario World");
        set_nombres.add("Super Punch-Out!!"); 
        set_nombres.add("Super Mario Kart"); 
        set_nombres.add("Donkey Kong"); 

        Iterator<String> iter = set_nombres.iterator();

        while(iter.hasNext()) {
          System.out.println(it.next());
        }
    }
}