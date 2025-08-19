package dev.aymee.view;

import java.util.Scanner;

public class FilterMomentsListView {
    Scanner scanner;

    public FilterMomentsListView(Scanner scanner) {
        this.scanner = scanner;
    }
   
    public int filterMoments(){
       int option=0;
        do{
        System.out.println("""
                Filtrar por ...:
                        1. Emoción
                        2. Fecha
                        3. Valoración
                Ingrese una opción:
                """);
      String input = scanner.nextLine();
      try{
        option=Integer.parseInt(input);
        if (option < 1 || option > 3) {
                System.out.println("Opción inválida. Solo puede ingresar 1, 2 o 3.");}
      }
      catch(Exception e){
        System.out.println("Solo puede insertar números 1, 2 o 3");
      }
        }
        while (option<1||option>3);

        return option;
    }

}
