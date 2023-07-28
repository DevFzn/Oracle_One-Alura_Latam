package com.bytebank.test;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TestAcortaDecim {
    public static void main(String[] args) {
        double d1 = 0.123456789D;
        double recortado;
        for (int i = 0; i < 9; i++) {
            recortado = acortaDecimales(d1, i+1);
            System.out.println(recortado);
        }
    }
    public static double acortaDecimales(double valor, int decimales) {
        String patron = "#.";
        patron += "#".repeat(decimales);
        DecimalFormat df = new DecimalFormat(patron);
        df.setRoundingMode(RoundingMode.FLOOR);
        
        return Double.parseDouble(df.format(valor));
    }
}
