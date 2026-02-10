import java.util.ArrayList;

/**
 * Código refactorizado para la práctica de refactorización.
 * Aplicado: Extract Method y Extract Constant.
 */
public class ProcesadorPedidos {

    // Constantes (Extract Constant)
    private static final double IVA = 0.21;
    private static final double DESCUENTO = 0.10;
    private static final double COSTE_ENVIO = 15.95;

    public double procesar(ArrayList<String> listaNombres, ArrayList<Double> precios) {
        double totalSinImpuestos = 0;

        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            System.out.println("Añadiendo producto: " + listaNombres.get(i));
            totalSinImpuestos = totalSinImpuestos + precios.get(i);
        }

        // Lógica de descuento
        if (totalSinImpuestos > 100) {
            System.out.println("Descuento aplicado.");
            totalSinImpuestos = totalSinImpuestos - (totalSinImpuestos * DESCUENTO);
        }

        // IVA (Extract Method)
        double totalConImpuestos = calcularTotalConIVA(totalSinImpuestos);

        // Gastos de envío (Extract Method)
        totalConImpuestos = aplicarGastosEnvio(totalConImpuestos);

        return totalConImpuestos;
    }

    // Método extraído para el cálculo del IVA
    private double calcularTotalConIVA(double totalSinImpuestos) {
        return totalSinImpuestos + (totalSinImpuestos * IVA);
    }

    // Método extraído para los gastos de envío
    private double aplicarGastosEnvio(double totalConImpuestos) {
        if (totalConImpuestos < 500) {
            totalConImpuestos = totalConImpuestos + COSTE_ENVIO;
        }
        return totalConImpuestos;
    }
}
