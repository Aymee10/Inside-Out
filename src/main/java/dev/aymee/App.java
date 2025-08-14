package dev.aymee;

import dev.aymee.controller.MainController;

public final class App {
    private App() {
    }
    public static void main(String[] args) {
        // Crea una instancia del controlador principal y lo inicia.
        MainController mainController = new MainController();
        mainController.start();
    }
}