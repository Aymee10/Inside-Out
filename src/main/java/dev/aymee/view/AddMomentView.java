package dev.aymee.view;
import java.time.LocalDate;
import java.util.Scanner;
import dev.aymee.model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class AddMomentView {
  Scanner scanner;

  public AddMomentView(Scanner scanner) {
    this.scanner = scanner;
  }
  
  public String askTitle(){
    System.out.println("Ingrese el título del momento");
    return scanner.nextLine();
  }

   public String askDescription(){
    System.out.println("Ingrese la descripción del momento");
    return scanner.nextLine();
  }

  public Emotion  askEmotion(){
     System.out.println("Seleccione una emoción:");
     Emotion[] emotions=Emotion.values();

     for (int i = 0; i < emotions.length; i++) {
            System.out.println((i + 1) + ". " + emotions[i].name().charAt(0) + emotions[i].name().substring(1).toLowerCase());
        }
        int option=-1;
        while (option<0||option>emotions.length) {
            System.out.println("Seleccione el número de la opción");
            try {
                  option = Integer.parseInt(scanner.nextLine());
                  if(option<0||option>emotions.length){
                    System.out.println("El número seleccionado no es una opción válida. Intente de nuevo");
                  }
            } catch (Exception e) {
                System.out.println("Opción no válida, solo admite números. Intente de nuevo");
            }
        }
        return emotions[option-1];
  }

  public LocalDate askDate(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date=null;


while (date == null) {
            System.out.print("Ingresa la fecha (dd/mm/yyyy): ");
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato no válido, intenta de nuevo.");
            }
        }
        return date;
  }
}
