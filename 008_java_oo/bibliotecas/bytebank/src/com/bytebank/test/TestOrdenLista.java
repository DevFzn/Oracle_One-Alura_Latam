package com.bytebank.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bytebank.modelo.Cliente;
import com.bytebank.modelo.Cuenta;
import com.bytebank.modelo.CuentaAhorro;
import com.bytebank.modelo.CuentaCorriente;

public class TestOrdenLista {

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
        // Ordenar las cuentas
        // Forma Actual 1
        // Comparator<? extends Cuenta> c
        // Comparator es una interfáz funcional, no se requiere instanciar un Comparator,
        //Comparator<Cuenta> comparator = new OrdenadorPorNroCuenta();
        //lista.sort(comparator);
        
        // Forma Actual
        //lista.sort(new OrdenadorPorNroCuenta());
        // Forma Actual Función anónima (no requiere declarar clases para operar)
        lista.sort(new Comparator<Cuenta>() {
            @Override
            public int compare(Cuenta o1, Cuenta o2) {
                return (Integer.compare(o1.getNumero(), o2.getNumero()));
            }
        });
        
        // Forma Antigua
        //Collections.sort(lista, new OrdenadorPorNroCuenta());
        System.out.println("Despues de ordenar por nro. de cta.");
        for (Cuenta cuenta : lista) {
            System.out.println(cuenta);
}
        
        // Forma Actual 1
        // Comparator es una interfáz funcional, no se requiere instanciar un Comparator,
        //Comparator<Cuenta> comp_nombre_titular = new OrdenadorPorNombreTitular();
        //lista.sort(comp_nombre_titular);
        
        // Forma Actual 2
        //lista.sort(new OrdenadorPorNombreTitular());
        
        // Forma Antigua
        //Collections.sort(lista, new OrdenadorPorNombreTitular());
        Collections.sort(lista, new Comparator<Cuenta>() {
            @Override
            public int compare(Cuenta o1, Cuenta o2) {
                return o1.getTitular().getNombre().compareTo(o2.getTitular().getNombre());
            }
        });
        System.out.println("Despues de ordenar por nombre:");
        for (Cuenta cuenta : lista) {
            System.out.println(cuenta);
        }
    
        // Orden "Natural" establecido en Cuenta().compareTo()
        // Forma Antigua
        Collections.sort(lista);
        //Collections.reverse(lista);
        System.out.println("Despues de ordenar por Orden Natural:");
        for (Cuenta cuenta : lista) {
            System.out.println(cuenta);
        }
    }
}

class OrdenadorPorNroCuenta implements Comparator<Cuenta> {
    @Override
    public int compare(Cuenta o1, Cuenta o2) {
        // Forma básica
        //if (o1.getNumero() == o2.getNumero()) {
        //    return 0;
        //} else if (o1.getNumero() > o2.getNumero()) {
        //    return 1;
        //} else {
        //    return -1;
        
        // Forma intermedia
        //return (o1.getNumero() - o2.getNumero());
        
        // Forma WRAPPER
        return (Integer.compare(o1.getNumero(), o2.getNumero()));
    }
}
    
class OrdenadorPorNombreTitular implements Comparator<Cuenta> {
    @Override
    public int compare(Cuenta o1, Cuenta o2) {
        return o1.getTitular().getNombre().compareTo(o2.getTitular().getNombre());
    }
}

