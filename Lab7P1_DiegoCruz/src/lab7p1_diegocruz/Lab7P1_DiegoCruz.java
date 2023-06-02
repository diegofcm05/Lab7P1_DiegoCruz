/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_diegocruz;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author dfcm9
 */
public class Lab7P1_DiegoCruz {

    static Scanner sc = new Scanner (System.in);
    static Random rand = new Random ();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         boolean resp = true;
        while (resp){
            System.out.println("Menu Lab 7");
            System.out.println("1. She shoots, She Scores!");
            System.out.println("2. Piedra, Papel o..");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion: ");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                   
                {
                        
                    String filas, columnas, balas;
                    System.out.println("Ingrese el numero de filas: ");
                    filas = sc.next();
                    while (!revisar(filas) || Integer.parseInt(filas)<2){
                        System.out.println("El valor debe ser un numero y el numero no puede ser 1. Intente de nuevo");
                        filas = sc.next();
                    }
                    
                    System.out.println("Ingrese el numero de columas: ");
                    columnas = sc.next();
                    while (!revisar(columnas) || Integer.parseInt(columnas)<2){
                        System.out.println("El valor debe ser un numero y el numero no puede ser 1. Intente de nuevo");
                        columnas = sc.next();
                    }
                    
                    int multi = Integer.parseInt(filas)*Integer.parseInt(columnas);
                    System.out.println("Area: "+ multi);
                    
                    while (multi > 88){
                        System.out.println("El tamanio de la matriz es mayor a 88. Intente de nuevo.");
                        System.out.println("Ingrese el numero de filas: ");
                        filas = sc.next();
                        while (!revisar(filas)|| Integer.parseInt(filas)<2){
                            System.out.println("El valor debe ser un numero y el numero no puede ser 1. Intente de nuevo");
                            filas = sc.next();
                        }

                        System.out.println("Ingrese el numero de columas: ");
                        columnas = sc.next();
                        while (!revisar(columnas) || Integer.parseInt(columnas)<2){
                            System.out.println("El valor debe ser un numero y el numero no puede ser 1. Intente de nuevo");
                            columnas = sc.next();
                        }
                        multi = Integer.parseInt(filas)*Integer.parseInt(columnas);
                    }
                    
                    System.out.println("Ingrese la cantidad de disparos de los jugadores: ");
                    balas = sc.next();
                    while (!revisar(balas)){
                        System.out.println("El valor debe ser un numero. Intente de nuevo");
                        balas = sc.next();
                    }
                    while (Integer.parseInt(balas) > (multi/2)){
                        System.out.println("El numero de balas debe ser menor. Intente de nuevo");
                        balas = sc.next();
                        while (!revisar(balas)){
                        System.out.println("El valor debe ser un numero. Intente de nuevo");
                        balas = sc.next();
                    }
                        
                    }
                    System.out.println("------Tablero para jugar-------");
                    
                    int matrizjue [][] = lectura(Integer.parseInt(filas),Integer.parseInt(columnas), multi);
                    printmatriz(matrizjue);
                    
                    int puntos1 = 0;
                    int puntos2 = 0;
                    
                    int numbalas = Integer.parseInt(balas);
                    for (int i = 1; i <= numbalas; i++) {
                        System.out.println("Eliga que numero disparar jugador 1!");
                        int disp1 = sc.nextInt();
                        while (disp1 == 99 || disp1 == 88){
                            System.out.println("Te crees listo? No puedes disaparar a ese numero. Selecciona otro.");
                            disp1 = sc.nextInt();
                        }
                        if (tiro(matrizjue,disp1)){
                            System.out.println("Tiro Acertado!");
                            puntos1+= disp1;//aqui
                            for (int j = 0; j < Integer.parseInt(filas); j++) {
                                for (int k = 0; k < Integer.parseInt(columnas); k++) {
                                    if (disp1 == matrizjue[j][k]){
                                        matrizjue[j][k] = 99;
                                        break;
                                        
                                    }
                                }
                                
                            }
                        }
                        else{
                            System.out.println("Ha fallado el tiro!");
                        }
                        System.out.println("Le quedan "+ (numbalas-i)+ " balas, Jugador 1");
                        printmatriz(matrizjue);
                        
                        System.out.println("Eliga que numero disparar jugador 2!");
                        int disp2 = sc.nextInt();
                        while (disp2 == 99 || disp2 == 88){
                            System.out.println("Te crees listo? No puedes disaparar a ese numero. Selecciona otro.");
                            disp2 = sc.nextInt();
                        }
                        if (tiro(matrizjue,disp2)){
                            System.out.println("Tiro Acertado!");
                            puntos2+= disp2;
                            for (int j = 0; j < Integer.parseInt(filas); j++) {
                                for (int k = 0; k < Integer.parseInt(columnas); k++) {
                                    if (disp2 == matrizjue[j][k]){
                                        matrizjue[j][k] = 88;
                                        break;
                                        
                                    }
                                }
                                
                            }
                        }
                        else{
                            System.out.println("Ha fallado el tiro!");
                        }
                        System.out.println("Le quedan "+ (numbalas-i)+ " balas, Jugador 2");
                        printmatriz(matrizjue);
                        
                        
                    }
                    
                    if (puntos1>puntos2){
                        System.out.println("Jugador 1 gana con: "+ puntos1);
                        System.out.println("Jugador 2 pierde con: "+ puntos2);
                    }
                    else if(puntos1==puntos2){
                        System.out.println("Jugador 1 empata con: "+ puntos1);
                        System.out.println("Jugador 2 empata con: "+ puntos2);
                    }
                    else{
                        System.out.println("Jugador 2 gana con: "+ puntos2);
                        System.out.println("Jugador 1 pierde con: "+ puntos1);
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("Elija que quiere usar:");
                    System.out.println("1. Piedra");
                    System.out.println("2. Papel");
                    System.out.println("3. Tijera");
                    System.out.println("4. Pichete");
                    System.out.println("5. Spock");
                    int numus = sc.nextInt();
                    while (numus <1 || numus > 5){
                        System.out.println("Opcion Invalida. Ingrese otra opcion.");
                        numus = sc.nextInt();
                    }
                    
                    switch(numus){
                        case 1:
                        {
                            System.out.println("El usuario ha seleccionado Piedra!");
                            break;
                        }
                        case 2:
                        {
                            System.out.println("El usuario ha seleccionado Papel!");
                            break;
                        }
                        case 3:
                        {
                            System.out.println("El usuario ha seleccionado Tijera!");
                            break;
                        }
                        case 4:
                        {
                            System.out.println("El usuario ha seleccionado Pichete!");
                            break;
                        }
                        case 5:
                        {
                            System.out.println("El usuario ha seleccionado Spock!");
                            break;
                        }
                            
                    }
                    
                    int nummaq = 1+ rand.nextInt(5);
                    
                    switch(nummaq){
                        case 1:
                        {
                            System.out.println("La maquina ha seleccionado Piedra!");
                            break;
                        }
                        case 2:
                        {
                            System.out.println("La maquina ha seleccionado Papel!");
                            break;
                        }
                        case 3:
                        {
                            System.out.println("La maquina ha seleccionado Tijera!");
                            break;
                        }
                        case 4:
                        {
                            System.out.println("La maquina ha seleccionado Pichete!");
                            break;
                        }
                        case 5:
                        {
                            System.out.println("La maquina ha seleccionado Spock!");
                            break;
                        }
                            
                    }
                   // int [][] matresu = new int [5][5];
                    int [][] matresu =  {{2,0,1,1,0},
                                        {1,2,0,0,1},
                                        {0,1,2,1,0},
                                        {0,1,0,2,1},
                                        {1,0,1,0,2}};
                switch (matresu[numus-1][nummaq-1]) {
                    case 0:
                        System.out.println("La maquina gana!");
                        break;
                    case 1:
                        System.out.println("El jugador gana!");
                        break;
                    default:
                        System.out.println("Hay un empate!");
                        break;
                }
                break;
                    
                }
                
                case 3:
                {
                    resp = false;
                    break;
                }
                
            }
        }
    }
    
    public static int [][] lectura (int x, int y, int z){
        int [][] temporal = new int [x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int random = rand.nextInt(z)+1;
                while (repetido(temporal,random)){
                    random = rand.nextInt(z)+1;
                    
                }
                temporal[i][j]= random;
                
            }// fin for columnas j
            
        }// fin for filas i
        
        return temporal;
    }
    
    public static void printmatriz(int [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            
            for (int j = 0; j < matriz[i].length; j++) {   
                if (matriz[i][j] < 10){
                    System.out.print(" "+matriz[i][j]+" ");
                }
                else{
                System.out.print(matriz[i][j]+" "); 
                }
            }
            System.out.println("");
        }
    }// fin metodo que imprime matrices  
    
    public static boolean revisar(String numero){
        boolean bueno = true;
        for (int i = 0; i < numero.length(); i++) {
            char a = numero.charAt(i);
            int a1 = a;
            if (a1 < 48 || a1 > 57){
                bueno = false;
                break;
            }
            
            
        }
        return bueno;
    }
    
    public static boolean repetido(int [][] matriz, int x){
        boolean rep = false;
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (x == matriz[i][j]){
                    rep = true;
                    break;  
            }
                
            }
            
        }
        return rep;
    }
    
    public static boolean tiro(int [][] matriz, int x){
        boolean acerto = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++){
                if (x == matriz[i][j]){
                    acerto = true;
                    break;
                }
                
            }
            
        }
        return acerto;
    }
    
     

        
    
}
