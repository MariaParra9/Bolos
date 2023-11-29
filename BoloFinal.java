/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bolofinal;

/**
 *
 * @author Maria Parra
 * @author Santiago Sandoval
 */

//Librerias importadas de java 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Clase principal del codigo */
public class BoloFinal {
    
    // Se crea una lista que guardara la cantidad de pinos derribados por turnos lista no puede ser mayor a 21
    private List<Integer> tiradas = new ArrayList<>();
    
    // Metodo principal que ejecuta todo el programa
    public static void main(String[] args) {
        // Instanciamos el objeto de esta clase para hacer uso de los metodos de la clase
        BoloFinal rt = new BoloFinal();
        
        // Se creo un objeto que permite usar la propiedad de la librerida Scanner
        Scanner scanner = new Scanner(System.in);
        
        // Variable que representa ca cantidad totales de rondas en el juego
        int rondas = 10;
        
        // Ciclo que recorre las distintas rondas del juego
        for (int ronda = 1; ronda <= rondas; ronda++) {
            System.out.println("----- Ronda " + ronda + " -----");
            
            // Variables que guardaran los distintos tiros de cada ronda
            int tiro1 = 0;
            int tiro2 = 0;
            int tiro3 = 0;
            
            // Condicional para separar todas las rondas de la ronda numero 10
            if(ronda != 10){
                // Primer tiro
                System.out.print("Ingrese el valor del primer tiro (0-10): ");
                tiro1 = scanner.nextInt();
            
                if (tiro1 < 0 || tiro1 > 10) {
                    System.out.println("Valor inválido. Se asigna 0 para el tiro 1.");
                    tiro1 = 0;
                    rt.registrarTirada(tiro1);
                }else{
                    rt.registrarTirada(tiro1);
                }

                // Segundo tiro
                if (tiro1 < 10) {
                    System.out.print("Ingrese el valor del segundo tiro (0-" + (10 - tiro1) + "): ");
                    tiro2 = scanner.nextInt();

                    if (tiro2 < 0 || tiro2 > (10 - tiro1)) {
                        System.out.println("Valor inválido. Se asigna 0 para el tiro 2.");
                        tiro2 = 0;
                        rt.registrarTirada(tiro2);
                    }else{
                        rt.registrarTirada(tiro2);
                    }
                }
            }else{
                //Primer tiro de la ronda 10
                System.out.print("Ingrese el valor del primer tiro (0-10): ");
                tiro1 = scanner.nextInt();
                    if (tiro1 < 0 || tiro1 > 10) {
                        System.out.println("Valor inválido. Se asigna 0 para el tiro 1.");
                        tiro1 = 0;
                        rt.registrarTirada(tiro1);
                    }else{
                        rt.registrarTirada(tiro1);
                    }
                // Segundo tiro de la ronda 10
                if(tiro1 == 10){
                    System.out.print("Ingrese el valor del segundo tiro (0-10): ");
                    tiro2 = scanner.nextInt();
                        if (tiro2 < 0 || tiro2 > 10) {
                            System.out.println("Valor inválido. Se asigna 0 para el tiro 2.");
                            tiro2 = 0;
                            rt.registrarTirada(tiro2);
                        }else{
                            rt.registrarTirada(tiro2);
                        }
                }else{
                    System.out.print("Ingrese el valor del segundo tiro (0-" + (10 - tiro1) + "): ");
                    tiro2 = scanner.nextInt();

                    if (tiro2 < 0 || tiro2 > (10 - tiro1)) {
                        System.out.println("Valor inválido. Se asigna 0 para el tiro 2.");
                        tiro2 = 0;
                        rt.registrarTirada(tiro2);
                    }else{
                        rt.registrarTirada(tiro2);
                    }
                }
               //tercer tiro de la ronda 10
               if(tiro2 == 10){
                    System.out.print("Ingrese el valor del tercer tiro (0-10): ");
                    tiro3 = scanner.nextInt();
                        if (tiro3 < 0 || tiro3 > 10) {
                            System.out.println("Valor inválido. Se asigna 0 para el tiro 3.");
                            tiro3 = 0;
                            rt.registrarTirada(tiro3);
                        }else{
                            rt.registrarTirada(tiro3);
                        }
                }else{
                   if(tiro1 != 10){
                       System.out.print("Ingrese el valor del tercer tiro (0-" + (10 - tiro2) + "): ");
                        tiro3 = scanner.nextInt();
                            if (tiro3 < 0 || tiro3 > 10) {
                            System.out.println("Valor inválido. Se asigna 0 para el tiro 3.");
                            tiro3 = 0;
                            rt.registrarTirada(tiro3);
                        }else{
                            rt.registrarTirada(tiro3);
                        }
                   }else{
                        System.out.print("Ingrese el valor del tercer tiro (0-10): ");
                        tiro3 = scanner.nextInt();

                        if (tiro3 < 0 || tiro3 > (10 - tiro2)) {
                            System.out.println("Valor inválido. Se asigna 0 para el tiro 3.");
                            tiro3 = 0;
                            rt.registrarTirada(tiro3);
                        }else{
                            rt.registrarTirada(tiro3);
                        }   
                   }
                }
            }
                // Calcular puntaje de la ronda
                int puntajeRonda = tiro1 + tiro2;
            
            // Aplicar bonos para chucha o media chuza
            if (tiro1 == 10) {
                System.out.println("¡Chuza!");
            } else if (puntajeRonda == 10) {
                System.out.println("¡Media Chuza!");
            }
        }
        // Mostrar la puntuación total
        System.out.println("Puntuación total: " + rt.calcularPuntuacion());
         
        }
        // Método para registrar una tirada
        public void registrarTirada(int pinosTirados) {
            tiradas.add(pinosTirados);
        }

        // Método para calcular la puntuación total
        public int calcularPuntuacion() {
            int puntuacionTotal = 0;
            int tiradaActual = 0;

            // Ciclo para los 10 turnos
            for (int turno = 0; turno < 10; turno++) {
                if (esPleno(tiradaActual)) {
                    // Si es un pleno, suma 10 más el bono del próximo turno
                    puntuacionTotal += 10 + bonoPleno(tiradaActual);
                    tiradaActual += 1;
                } else if (esSemipleno(tiradaActual)) {
                    // Si es un semipleno, suma 10 más el bono del próximo tiro
                    puntuacionTotal += 10 + bonoSemipleno(tiradaActual);
                    tiradaActual += 2;
                } else {
                    // En otros casos, suma el total de los pinos tirados en dos tiros
                    puntuacionTotal += tiradas.get(tiradaActual) + tiradas.get(tiradaActual + 1);
                    tiradaActual += 2;
                }
            }

            return puntuacionTotal;
        }

        // Métodos de ayuda para verificar si una tirada es pleno o semipleno, y obtener
        // bonos
        private boolean esPleno(int tiradaActual) {
            return tiradas.get(tiradaActual) == 10;
        }

        // El private permite que solo lo pueda ver quien instancia la clase
        private boolean esSemipleno(int tiradaActual) {
            return tiradas.get(tiradaActual) + tiradas.get(tiradaActual + 1) == 10;
        }

        // El get es un metodo de los objetos lista en java para obtener el valor de la posicion que se le indique
        private int bonoPleno(int tiradaActual) {
            return tiradas.get(tiradaActual + 1) + tiradas.get(tiradaActual + 2);
        }

        private int bonoSemipleno(int tiradaActual) {
            return tiradas.get(tiradaActual + 2);
        }
}