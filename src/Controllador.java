import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controllador {

	public static void main(String[] args) throws SQLException, IOException {
		@SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        int idClient;
 
        while (!salir) {
        	System.out.println("####################################");
        	System.out.println("### GENERACIÓN FICHERO PROVEEDOR ###");
        	System.out.println("####################################");
            System.out.println("1. Generar fichero.");
            System.out.println("2. Salir.");
 
            try {
                System.out.println("Escribe una de las opciones: ");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce el ID del Cliente: ");
                        idClient = sn.nextInt();
                        montaFichero(idClient);
                        break;
                    case 2:
                    	salir = true;
                    	System.out.println("App Cerrada.");
                        break;
                    default:
                        System.out.println("Solo elige 1 o 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
	}
	
	public static void montaFichero(int idClient) throws SQLException, IOException {
		Fichero fich = new Fichero();
		fich.montaFicheroF(idClient);
	}

}
