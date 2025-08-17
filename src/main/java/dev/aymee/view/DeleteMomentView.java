package dev.aymee.view;

import java.util.Scanner;


public class DeleteMomentView {
     Scanner scanner;

     public DeleteMomentView(Scanner scanner) {
        this.scanner=scanner;
     }

public int delete() {
    int result = -1;

    do {
        System.out.println("Ingresa el identificador del momento:");
        String input = scanner.nextLine();

        try {
            result = Integer.parseInt(input);

            if (result <= 0) {
                System.out.println("Solo números positivos, intente de nuevo");
            }

        } catch (NumberFormatException e) {
            System.out.println("Solo números positivos, intente de nuevo");
        }

    } while (result <= 0);

    return result;
}

}
