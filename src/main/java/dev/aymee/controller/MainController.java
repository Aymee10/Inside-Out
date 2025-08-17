package dev.aymee.controller;

import java.util.Scanner;

import dev.aymee.repository.MomentsRepository;
import dev.aymee.view.AddMomentView;
import dev.aymee.view.DeleteMomentView;
import dev.aymee.view.ListMomentsView;
import dev.aymee.view.MainMenuView;
import dev.aymee.view.MessageView;
import dev.aymee.service.MomentService;


public class MainController {

    private final MomentsRepository repository;
    private final MomentService momentService;
    private final AddMomentView addMomentView;
    private final MomentController momentController;
    private final MessageView messageView;
    private final MainMenuView mainMenuView;
    private final Scanner scanner;
    private final DeleteMomentView deleteMomentView;

    public MainController() {
        this.scanner = new Scanner(System.in);
        this.repository = new MomentsRepository();
        this.momentService= new MomentService(repository);
        this.addMomentView = new AddMomentView(scanner);
        this.momentController = new MomentController(addMomentView, momentService);
        this.messageView = new MessageView();
        this.mainMenuView = new MainMenuView(scanner);
        this.deleteMomentView=new DeleteMomentView(scanner);
    }

    public void start() {
        boolean clicExit = false;
        while (!clicExit) {
            int option = mainMenuView.showMenu();
            switch (option) {
                case 1: {
                    String result = momentController.addMoment();
                    messageView.messageShow(result);
                    break;
                }
                case 2: {
                    ListMomentsView list = new ListMomentsView();
                    list.listMoments(momentController.listMoments());
                    break;
                }
                case 3: {
                    String result = momentController.deleteMoment();
                    messageView.messageShow(result);
                    break;
                }
                case 4: {
                    // Lógica para la opción 4
                    break;
                }
                case 5: {
                    messageView.messageShow("Hasta la próxima!!!");
                    clicExit = true;
                    break;
                }
                default:
                    messageView.messageShow("Revise las opciones y vuelva a intentar");
            }
        }
        scanner.close();
    }
}