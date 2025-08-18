package dev.aymee.view;

import java.util.List;

import dev.aymee.repository.MomentsRepository;

public class ListMomentsView {
   MomentsRepository repository;

   public ListMomentsView() {
    
   }
   
   public void listMoments(List<String> moments){
      if(moments.size()==0){
         System.out.println("No existen momentos para mostrar, añada momentos vividos en la opción 1");
      }else{
     System.out.println("Lista de momentos vividos:");
    for (int i = 0; i < moments.size(); i++) {
            System.out.println(moments.get(i));
        }
        System.out.println();
   }}
    
}
