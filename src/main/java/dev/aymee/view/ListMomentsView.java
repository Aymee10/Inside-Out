package dev.aymee.view;

import java.util.List;

import dev.aymee.repository.MomentsRepository;

public class ListMomentsView {
   MomentsRepository repository;

   public ListMomentsView() {
    
   }
   
   public void ListMoments(List<String> moments){
     System.out.println("Lista de momentos vividos:");
    for (int i = 0; i < moments.size(); i++) {
            System.out.println((i + 1) + ". " + moments.get(i));
        }
        System.out.println();
   }
    
}
