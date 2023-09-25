import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void asignarCasillerosAleatorios(String[] bloques, int[] casilleros) {
        Random random = new Random();

        for (int i = 0; i < bloques.length; i++) {
            casilleros[i] = random.nextInt(33);
        }
    }

    public static void mostrarDisponibilidadCasilleros(String[] bloques, int[] casilleros) {
        System.out.println("Disponibilidad de casilleros:");
        for (int i = 0; i < bloques.length; i++) {
            System.out.println("En  " + bloques[i] + " hay " + casilleros[i] + " casilleros disponibles.");
        }
    }

    public static void registroUsuario() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Ingresa Tu Nombre Completo: ");
        String nombre = kb.nextLine();
        System.out.println("Ingresa Tu Correo Electrónico de la Universidad: ");
        String correo = kb.nextLine();
        System.out.println("Ingresa Tu Nombre de Usuario: ");
        String usuario = kb.nextLine();
        System.out.println("Ingresa Tu Contraseña: ");
        String contrasena = kb.nextLine();
        System.out.println(" ");
        System.out.println("Cuenta creada de forma exitosa. Bienvenido " + nombre);
    }

    public static void reservarCasillero() {
    int bloque; 
    int seccion;
    Scanner kb = new Scanner(System.in);

    System.out.print("Seleccione el bloque en el que desea reservar su casillero (33, 34, 35): ");
    bloque = kb.nextInt();
    
    if (bloque == 33) {
      System.out.print("Seleccione en qué sección desea reservar el casillero (# 14, 15, 97): ");
    } else if (bloque == 34) {
      System.out.print("Seleccione en qué sección desea reservar el casillero (# 16, 17): ");
    } else if (bloque == 35) {
      System.out.print("Seleccione en qué sección desea reservar el casillero (# 18, 19): ");
    } else {
      System.out.println("El bloque ingresado no se encuentra disponible.");
      return; 
    }
    seccion = kb.nextInt();
    
    if (seccion == 97 || seccion == 14 || seccion == 15 || seccion == 16 || seccion == 17 || seccion == 18 || seccion == 19) {
      System.out.println("Su reserva se hizo correctamente. ¡Recuerde que tiene 15 minutos para activarla en la sección que haya elegido! ");
    } else {
      System.out.println("La sección ingresada no se encuentra disponible.");
    }
  }

    public static int Mi_casillero(Scanner kb, String[] ingreso_objetos, int contador) {
        System.out.println("Bienvenido a la opción MI CASILLERO !!!");
        System.out.println("Ingrese los objetos que dejará en el casillero (o escriba 'fin' para terminar):");
        kb.nextLine();

        while (contador < ingreso_objetos.length) {
            System.out.print((contador + 1) + ": ");

            String objeto = kb.nextLine();
            if (objeto.equals("fin")) {
                break;
            }

            ingreso_objetos[contador] = objeto;
            contador++;
        }

        return contador;
    }

    public static void imprimirCasillero(String[] arreglo, int contador) {
        System.out.println("Objetos que tienes en el casillero:");
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ": " + arreglo[i]);
        }
    }

    public static void ubicacionCasilleros() {
        Scanner kb = new Scanner(System.in);
        int bloque;
        System.out.println("Los casilleros están organizados en secciones de 32 casilleros cada una. ");
        System.out.println();
        System.out.println("En esta forma:");
        System.out.println("* * * * || * * * *");
        System.out.println("* * * * || * * * *");
        System.out.println("* * * * || * * * *");
        System.out.println("* * * * || * * * *");
        System.out.println();

        System.out.print("¿En qué bloque está buscando su casillero? (Disponibles bloque 33, 34, 35): ");
        bloque = kb.nextInt();

        switch (bloque) {
            case 33:
                System.out.println("En el bloque 33 hay 3 secciones de casilleros en el primer piso (# 14, 15 y 97). ");
                break;
            case 34:
                System.out.println("En el bloque 34 hay 2 secciones de casilleros en el primer piso (# 16 y 17). ");
                break;
            case 35:
                System.out.println("En el bloque 35 hay 2 secciones de casilleros en el primer piso (# 18 y 19). ");
                break;
            default:
                System.out.println("Bloque no válido.");
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int tamanoArreglo = 15;
        String[] ingreso_objetos = new String[tamanoArreglo];
        int contador = 0;
        boolean salir = false;

        while (!salir) {
            System.out.println("Ingrese la opción que necesita:");
            System.out.println("1. Hacer registro de usuario");
            System.out.println("2. Hacer reserva de casillero");
            System.out.println("3. Ingresar objetos a Mi Casillero");
            System.out.println("4. Mostrar los objetos que tiene en el casillero");
            System.out.println("5. Ubicación de Casilleros");
            System.out.println("6. Mostrar Disponibilidad de Casilleros");
            System.out.println("7. Salir de la aplicación");

            int opcion = kb.nextInt();
            System.out.println();
                  switch (opcion) {
                case 1:
                    registroUsuario();
                    break;
                case 2:
                    reservarCasillero();
                    break;
                case 3:
                    contador = Mi_casillero(kb, ingreso_objetos, contador);
                    break;
                case 4:
                    imprimirCasillero(ingreso_objetos, contador);
                    break;
                case 5:
                    ubicacionCasilleros();
                    break;
                case 6:
                    String[] bloquesUniversidad = {
                            "Bloque 33", "Bloque 34", "Bloque 35"
                    };

                    int[] casillerosDisponibles = new int[bloquesUniversidad.length];

                    asignarCasillerosAleatorios(bloquesUniversidad, casillerosDisponibles);
                    mostrarDisponibilidadCasilleros(bloquesUniversidad, casillerosDisponibles);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
            System.out.println();
        }
    }
}