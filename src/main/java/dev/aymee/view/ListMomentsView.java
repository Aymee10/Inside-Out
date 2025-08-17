package dev.aymee.view;

import java.util.List;

import dev.aymee.repository.MomentsRepository;

public class ListMomentsView {
   MomentsRepository repository;

   public ListMomentsView() {
    
   }
   
   public void listMoments(List<String> moments){
     System.out.println("Lista de momentos vividos:");
    for (int i = 0; i < moments.size(); i++) {
            System.out.println(moments.get(i));
        }
        System.out.println();
   }
    
}
