package dev.aymee;

import java.util.Scanner;

import dev.aymee.view.*;
import dev.aymee.controller.*;
import dev.aymee.repository.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MomentsRepository repository = new MomentsRepository();
        AddMomentView addMomentView = new AddMomentView(scanner);
        MomentController momentController = new MomentController(addMomentView,repository);
        MessageView messageView=new MessageView();

        MainMenuView mainMenuView = new MainMenuView(scanner);

        boolean clicExit=false;
        while (!clicExit) {
            int option = mainMenuView.showMenu();
            switch (option) {
                case 1 :{
                    String result = momentController.addMoment();
                    messageView.messageShow(result);
                    break;
                }

                 case 2 :{
                    
                    break;
                }
                 case 3 :{
                   
                    break;
                }
                 case 4 :{
                    
                    break;
                }
                 case 5 :{
                     messageView.messageShow("Hasta luego");
                     clicExit=true;
                     break;
                }
                                
                default:
                     messageView.messageShow("Revise las opciones y vuelva a intentar");
            }
        }
scanner.close();
    }
}
