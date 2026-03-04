package com.githubjcsam.conversor;

import com.githubjcsam.conversor.modelo.Moneda;
import com.githubjcsam.conversor.service.ConversorService;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorService service = new ConversorService();

        int opcion = 0;


        while (opcion != 7){
            mostrarMenu();
            opcion = scanner.nextInt();

            if (opcion == 7){
                System.out.println("Finalizo el programa");
                break;
            }

            System.out.println("Ingrese la cantidad: ");
            double cantidad = scanner.nextDouble();

            try{
                double resultado = switch (opcion){
                    case 1 -> service.convertir(Moneda.USD, Moneda.ARS, cantidad);
                    case 2 -> service.convertir(Moneda.ARS, Moneda.USD, cantidad);
                    case 3 -> service.convertir(Moneda.USD, Moneda.BRL, cantidad);
                    case 4 -> service.convertir(Moneda.BRL, Moneda.USD, cantidad);
                    case 5 -> service.convertir(Moneda.USD, Moneda.COP, cantidad);
                    case 6 -> service.convertir(Moneda.COP, Moneda.USD, cantidad);
                    default -> {
                        System.out.println("Opcion invalida!");
                        yield 0;
                    }
                };
                if(opcion >= 1 && opcion <= 6){
                    System.out.println("Resultado: " + resultado);
                }
            }catch (Exception e){
                System.out.println("Error al convetir: " + e.getMessage());
            }
        }
        scanner.close();

    }

    private static void mostrarMenu(){
        System.out.println("""
                ****************************
                Conversor de monedas!
                1) Dolar >>> Peso Argentino
                2) Peso >>> Argentino Dolar
                3) Dolar >>> Real
                4) Real >>> Dolar
                5) Dolar >>> Peso colombiano
                6) Peso >>> colombiano Dolar
                7) Salir
                """);
        System.out.println("Elija una opcion valida: ");
    }
}
