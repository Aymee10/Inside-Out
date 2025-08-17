package dev.aymee.view;

import java.util.Scanner;

import dev.aymee.repository.MomentsRepository;

public class DeleteMomentView {
     Scanner scanner;

     public DeleteMomentView(Scanner scanner) {
        this.scanner=scanner;
     }

      public int delete(){
        System.out.println("Ingresa el identificador del momento:");
        System.out.println();
        String id= scanner.nextLine();
        int result=0;
       while (result<=0) {
         
        try{
          result=Integer.valueOf(id);
         
        }
        catch(ExceptionInInitializerError e){
          System.out.println("Solo números positivos, intente de nuevo");
         
        }}
        return result;
      }

}
