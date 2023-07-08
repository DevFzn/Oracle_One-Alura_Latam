package com.bytebank.test;

import com.bytebank.modelo.CuentaAhorro;

public class TestString {
	public static void main(String[] args) {
		String nombre = "DevFzn";
		nombre = nombre.replace('D', 'd');
		nombre = nombre.concat(" estudiando con Alura");
        System.out.println(nombre);
		
		printLine(nombre);
		printLine(nombre.indexOf("F"));
		printLine(nombre.charAt(3));
		printLine(new CuentaAhorro(11, 22));
	}
	
	public static void printLine(Object valor) {
		System.out.println(valor.toString());
	}
	// Sobrecargando método printLine()
	public static void printLine(String msj) {
		System.out.println(msj);
	}
	public static void printLine(int valor) {
		System.out.println(valor);
	}
	public static void printLine(char caracter) {
		System.out.println(caracter);
	}
}
