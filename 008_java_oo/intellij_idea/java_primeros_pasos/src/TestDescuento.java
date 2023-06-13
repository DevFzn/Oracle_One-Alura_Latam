public class TestDescuento {

    public static void main(String[] args) {

        int dscto;
        double valorDescuento, valorCompra, totalCompra;
        valorCompra = 250.0;

        if (valorCompra >= 100.0 && valorCompra <= 199.99){
            dscto = 10;
        } else if (valorCompra >= 200.0 && valorCompra <= 299.99) {
            dscto = 15;
        } else if (valorCompra >= 300.0) {
            dscto = 20;
        } else {
            dscto = 0;
        }

        valorDescuento = valorCompra * (dscto / 100.00 );
        totalCompra = valorCompra - valorDescuento;
        System.out.println("Total compra    : $"+valorCompra+"\n"+
                           "Descuento       : "+dscto+"%\n"+
                           "    Total Final : $"+totalCompra);
    }
}
