/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

import java.util.Random;
import java.util.Scanner;

public class tienda {

    //PARA DEFINIR LOS DIAS DE LA SEMANA
    String[] productos;
    int[][] ventas;
    String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};

    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    public void iniciar() {

        //PARTE EN LA QUE LE PREGUNTA AL USUARIO CUANTOS PRODUCTOS DESEA AGREGAR
        System.out.print("Cuantos productos hay: ");
        int n = sc.nextInt();
        sc.nextLine();

        productos = new String[n];
        ventas = new int[7][n];

        ingresarProductos();
        generarVentas();
        totalPorProducto();
        diaMayorVenta();
        productoMasVendido();
    }

    public void ingresarProductos() {

        //PARA GUARDAR LA VARIABLE DE LOS PRODUCTOS ASIGNADOS POR EL USUARIO
        for (int i = 0; i < productos.length; i++) {
            System.out.print("Nombre del producto " + (i + 1) + ": ");
            productos[i] = sc.nextLine();
        }

    }

    public void generarVentas() {

        //PARA GENERAR LAS CANTIDADES ALEATORIAS DE LOS PRODUCTOS
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < productos.length; j++) {
                ventas[i][j] = r.nextInt(10);
            }
        }

    }

    public void totalPorProducto() {

        //PARA SUMAR LAS CANTIDADES TOTALES DE CADA UNO DE LOS PRODUCTOS
        System.out.println("\nTotal por producto:");

        for (int j = 0; j < productos.length; j++) {

            int suma = 0;

            for (int i = 0; i < 7; i++) {
                suma += ventas[i][j];
            }

            System.out.println(productos[j] + " : " + suma);
        }

    }

    public void diaMayorVenta() {

        //PARA HACER EL FILTRO Y AGARRAR EL DIA QUE TUVO MAS VENTAS
        int mayor = 0;
        int posi = 0;

        for (int i = 0; i < 7; i++) {

            int suma = 0;

            for (int j = 0; j < productos.length; j++) {
                suma += ventas[i][j];
            }

            if (suma > mayor) {
                mayor = suma;
                posi = i;
            }

        }

        System.out.println("\nDia con mayor venta: " + dias[posi] + " con " + mayor + " ventas");
    }

    public void productoMasVendido() {

        //PARA FILTRAR EL PRODUCTO MAS VENDIDO
        int mayor = 0;
        int posi = 0;

        for (int j = 0; j < productos.length; j++) {

            int suma = 0;

            for (int i = 0; i < 7; i++) {
                suma += ventas[i][j];
            }

            if (suma > mayor) {
                mayor = suma;
                posi = j;
            }

        }

        System.out.println("\nProducto mas vendido: " + productos[posi] + " con " + mayor + " ventas");
    }

}
