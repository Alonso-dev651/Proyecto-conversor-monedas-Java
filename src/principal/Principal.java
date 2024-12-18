package principal;

import api.ConsultaApi;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        ConsultaApi consulta = new ConsultaApi();

        String monedaInicial = "";
        String monedaDeseada = "";

        while (true) {

            mostrarMenu();

            var accion = lectura.nextLine();

            if (accion.equalsIgnoreCase("7")) {
                break;
            }

            try {
                switch (accion) {
                    case "1" -> {
                        System.out.println("Ingresa el valor que deseas convertir:");
                        var cantidad = lectura.nextDouble();
                        monedaInicial = "USD";
                        monedaDeseada = "ARS";
                        double conversion = consulta.convertirMoneda(monedaInicial, monedaDeseada, cantidad);
                        System.out.println
                                ("El valor " + cantidad + " " + monedaInicial +
                                        " corresponde al valor final de ->" +
                                        conversion + " " + monedaDeseada);
                    }
                    case "2" -> {
                        System.out.println("Ingresa el valor que deseas convertir:");
                        var cantidad = lectura.nextDouble();
                        monedaInicial = "ARS";
                        monedaDeseada = "USD";
                        double conversion = consulta.convertirMoneda(monedaInicial, monedaDeseada, cantidad);
                        System.out.println
                                ("El valor " + cantidad + " " + monedaInicial +
                                        " corresponde al valor final de ->" +
                                        conversion + " " + monedaDeseada);
                    }
                    case "3" -> {
                        System.out.println("Ingresa el valor que deseas convertir:");
                        var cantidad = lectura.nextDouble();
                        monedaInicial = "USD";
                        monedaDeseada = "BRL";
                        double conversion = consulta.convertirMoneda(monedaInicial, monedaDeseada, cantidad);
                        System.out.println
                                ("El valor " + cantidad + " " + monedaInicial +
                                        " corresponde al valor final de ->" +
                                        conversion + " " + monedaDeseada);
                    }
                    case "4" -> {
                        System.out.println("Ingresa el valor que deseas convertir:");
                        var cantidad = lectura.nextDouble();
                        monedaInicial = "BRL";
                        monedaDeseada = "USD";
                        double conversion = consulta.convertirMoneda(monedaInicial, monedaDeseada, cantidad);
                        System.out.println
                                ("El valor " + cantidad + " " + monedaInicial +
                                        " corresponde al valor final de ->" +
                                        conversion + " " + monedaDeseada);
                    }
                    case "5" -> {
                        System.out.println("Ingresa el valor que deseas convertir:");
                        var cantidad = lectura.nextDouble();
                        monedaInicial = "USD";
                        monedaDeseada = "BOB";
                        double conversion = consulta.convertirMoneda(monedaInicial, monedaDeseada, cantidad);
                        System.out.println
                                ("El valor " + cantidad + " " + monedaInicial +
                                        " corresponde al valor final de ->" +
                                        conversion + " " + monedaDeseada);
                    }
                    case "6" -> {
                        System.out.println("Ingresa el valor que deseas convertir:");
                        var cantidad = lectura.nextDouble();
                        monedaInicial = "BOB";
                        monedaDeseada = "USD";
                        double conversion = consulta.convertirMoneda(monedaInicial, monedaDeseada, cantidad);
                        System.out.println
                                ("El valor " + cantidad + " " + monedaInicial +
                                        " corresponde al valor final de ->" +
                                        conversion + " " + monedaDeseada);
                    }
                    default -> System.out.println("Eliga una opcion valida");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Finalizo el programa");
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
}
