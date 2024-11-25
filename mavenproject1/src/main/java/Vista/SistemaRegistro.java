
package Vista;

import Controlador.GestionLenguaje;
import Modelo.LenguajeProgramacion;

import java.util.Scanner;

public class SistemaRegistro {
    private static GestionLenguaje gestionLenguaje=new GestionLenguaje();
    
    private static void menu(){
        Scanner scanner=new Scanner(System.in);
        int opcion;
        
        
        do{
            System.out.println("---REGISTROS DE LENGUAJE DE PROGRAMACION---"
                    + "\n1. Agregar Lenguaje"
                    + "\n2. Buscar Lenguaje"
                    + "\n3. Eliminar Lenguaje"
                    + "\n4. Imprimir registros"
                    + "\n5. Salir");
            System.out.println("\nSeleccionar opcion: ");
            opcion=scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("\nINGRESAR LA SIGUIENTE INFORMACION");
                    
                    System.out.print("Anio de creacion:");
                    int AnioCreacion=scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre:");
                    String NewNombre=scanner.nextLine();
                    System.out.print("Caracteristica:");
                    String Caracteristica=scanner.nextLine();
                    System.out.print("Utilizacion:");
                    String Utilizacion=scanner.nextLine();
                    
                    gestionLenguaje.AgregarLenguaje(AnioCreacion, Caracteristica, NewNombre, Utilizacion);
                    System.out.println("\n-NUEVO LENGUAJE AGREGADO-\n");
                    break;
                case 2:
                    System.out.println("\nIngrese el nombre del lenguaje que desea buscar: ");
                    String NombreBuscar=scanner.nextLine();
                    LenguajeProgramacion buscar=gestionLenguaje.BuscarLenguaje(NombreBuscar);
                    if (buscar != null) {
                        System.out.println(buscar);
                    }
                    else{
                        System.out.println("\nLenguaje no encontrado");
                    }
                    break;
                case 3:
                    System.out.println("\nIngrese el nombre del lenguaje que desea eliminar: ");
                    String NombreEliminar=scanner.nextLine();
                    if (gestionLenguaje.EliminarLenguaje(NombreEliminar)){
                        System.out.println("\n-REGISTRO ELIMINADO-\n");
                    }
                    else{
                        System.out.println("\n-NO SE ENCONTRO REGISTRO-\n");
                    }
                    break;
                case 4:
                    gestionLenguaje.ImprimirLenguaje();
                    break;
                case 5:
                    System.out.println("-EXIT-");
                    break;
                    
                default:
                    System.out.println("\n-OPCION INVALIDA-\n");
            }
        }  
        while(opcion != 5);
            scanner.close();
    }
    
    
    public static void main(String[]args){
        menu();
    }
}