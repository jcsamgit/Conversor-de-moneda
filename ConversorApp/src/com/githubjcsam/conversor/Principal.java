package com.githubjcsam.conversor;

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


        }

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
