package dev.aymee.view;
import java.util.Scanner;

public class MainMenuView {
    private Scanner scanner;

    public MainMenuView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int showMenu(){
        int option;

        System.out.println("""
           
        *******************************************
               
            Bienvenido a Mi Diario:
             1. Añadir momento
             2. Ver todos los momentos disponibles
             3. Eliminar un momento
             4. Filtrar los momentos
             5. Salir

             Por favor seleccione una opción: 
             
        ******************************************

                """);
                try {
                    option=Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    option=-1;
                }
                return option;
    }
}
