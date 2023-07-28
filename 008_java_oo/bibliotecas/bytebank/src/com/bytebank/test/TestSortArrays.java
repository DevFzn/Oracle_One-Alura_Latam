package com.bytebank.test;

import java.util.Arrays;

public class TestSortArrays{
    public static void main(String[] args){
        int[] numeros = new int[]{43, 15, 64, 22, 89};
        Arrays.sort(numeros); //método utilitario sort
        System.out.println(Arrays.toString(numeros)); //método utilitario toString
    }
}