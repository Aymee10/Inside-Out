package dev.aymee.view;

import java.time.LocalDate;
import java.util.Scanner;

import dev.aymee.model.Emotion;

public class FilterByDateView {
    Scanner scanner;

    public FilterByDateView(Scanner scanner) {
    this.scanner = scanner;
}

public LocalDate filterDate(){
    AddMomentView add=new AddMomentView(scanner);
    LocalDate date=add.askDate();
    return date;
}
}
