package principal;

import api.ConsultaApi;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();

        while (true) {
            mostrarMenu();

            String opcion = lectura.nextLine();

            if (opcion.equals("7")) {
                System.out.println("Finalizó el programa. ¡Gracias por usar el conversor!");
                break;
            }

            try {
                procesarOpcion(opcion, lectura, consulta);
            } catch (IllegalArgumentException e) {
                System.out.println("Opción inválida. Por favor, elija una opción válida.");
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                ********************************************
                Bienvenido al programa conversor de monedas:
                Elija la conversión a realizar:
                
                1. Dólar [USD] -> Peso Argentino [ARS]
                2. Peso Argentino [ARS] -> Dólar [USD]
                3. Dólar [USD] -> Real brasileño [BRL]
                4. Real brasileño [BRL] -> Dólar [USD]
                5. Dólar [USD] -> Boliviano [BOB]
                6. Boliviano [BOB] -> Dólar [USD]
                7. Salir
                
                Seleccione una opción válida:
                ********************************************
                """);
    }

    private static void procesarOpcion(String opcion, Scanner lectura, ConsultaApi consulta) {
        String monedaInicial;
        String monedaDeseada;

        switch (opcion) {
            case "1" -> {
                monedaInicial = "USD";
                monedaDeseada = "ARS";
            }
            case "2" -> {
                monedaInicial = "ARS";
                monedaDeseada = "USD";
            }
            case "3" -> {
                monedaInicial = "USD";
                monedaDeseada = "BRL";
            }
            case "4" -> {
                monedaInicial = "BRL";
                monedaDeseada = "USD";
            }
            case "5" -> {
                monedaInicial = "USD";
                monedaDeseada = "BOB";
            }
            case "6" -> {
                monedaInicial = "BOB";
                monedaDeseada = "USD";
            }
            default -> throw new IllegalArgumentException();
        }

        realizarConversion(monedaInicial, monedaDeseada, lectura, consulta);
    }

    private static void realizarConversion
            (String monedaInicial, String monedaDeseada, Scanner lectura, ConsultaApi consulta) {
        System.out.println("Ingrese el valor que desea convertir: ");
        double cantidad;

        try {
            cantidad = Double.parseDouble(lectura.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
            return;
        }

        double conversion = consulta.convertirMoneda(monedaInicial, monedaDeseada, cantidad);
        System.out.println("El valor " + cantidad + " " + monedaInicial +
                " corresponde a " + conversion + " " + monedaDeseada);
    }
}
