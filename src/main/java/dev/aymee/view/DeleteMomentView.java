package dev.aymee.view;

import java.util.Scanner;


public class DeleteMomentView {
     Scanner scanner;

     public DeleteMomentView(Scanner scanner) {
        this.scanner=scanner;
     }

      public int delete(){
        
        int result=-1;
       while (result<0) {
         System.out.println("Ingresa el identificador del momento:");
         System.out.println();
         String id= scanner.nextLine();
        try{
          result=Integer.parseInt(id);
         
        }
        catch(NumberFormatException e){
          System.out.println("Solo números positivos, intente de nuevo");
          
         
        }}
        return result;
      }

}
