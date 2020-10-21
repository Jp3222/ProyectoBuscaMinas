package proyectobuscaminas;

import java.util.Scanner;

public class ProyectoBuscaMinas {
    
    public static void main(String[] args) {
        // Instancias
        ProyectoBuscaMinas metodos = new ProyectoBuscaMinas();
        Tablero Tabla = new Tablero();
        Scanner V = new Scanner(System.in);

        //Matriz de posibilades
        String M[][] = Tabla.Tablero();

        //Matriz de interface
        String T[][] = {
            {"-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-"}
        };
        // (x / y) puntos cardinales
        // puntos del jugador
        // intentos del jugado
        int x, y, puntos = 0, intentos = 0;
        //Variable para definir el fin del programa
        boolean Fin = false;
        Tabla.Mostrar(M);
        do {
            System.out.println("Puntos: " + puntos);
            do {//Validacion
                System.out.println("Ingrese cordenada en y");
                y = V.nextInt();
            } while (y < 1 || y > 5);//se repite si el numero es mayor a 5

            do {//Validacion
                System.out.println("Ingrese cordenada en x");
                x = V.nextInt();
            } while (x < 1 || x > 5);//se repite si el numero es mayor a 5

            //Si el punto no es una mina retorna verdadero
            Fin = Tabla.comparaciones(M, y - 1, x - 1);

            //busqueda retornara una matriz
            //puntuaje lee una matriz para contar los " 0 " lo cual define los puntos
            puntos = Tabla.puntuaje(Tabla.Busqueda(M, T, (y - 1), (x - 1), 0));

            //si los puntos son 8 se imprimira un mensaje de ganaste
            //y acaba el ciclo
            if (puntos == 24) {
                System.out.println("Ganaste");
                break;
            }
            intentos++;//Aumento de intentos

            //se repite mientras fin sea verdadero
        } while (Fin);
        System.out.println("Puntuacion: " + puntos
                + "\nIntentos: " + (intentos + 1));
        
    }
    
}
