package dev.aymee.view;

import java.util.Scanner;

import dev.aymee.model.Emotion;

public class FilerByEmotionView {
Scanner scanner;

    public FilerByEmotionView(Scanner scanner) {
    this.scanner = scanner;
}

public Emotion filterEmotion(){
    AddMomentView add=new AddMomentView(scanner);
    Emotion emotion=add.askEmotion();
    return emotion;
}
}
