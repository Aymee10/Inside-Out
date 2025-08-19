package dev.aymee.view;

import java.util.Scanner;

public class FilterByCategoryView {
    Scanner scanner;
    AddMomentView view;

    public FilterByCategoryView(Scanner scanner) {
        this.scanner = scanner;
        view=new AddMomentView(scanner);
    }
    public boolean filterCategory(){
       return view.askIfIsGood();
       
    }
    
}
