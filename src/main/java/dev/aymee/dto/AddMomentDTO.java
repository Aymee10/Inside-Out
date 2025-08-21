package dev.aymee.dto;

import java.time.LocalDate;
import dev.aymee.model.Emotion;

public class AddMomentDTO {
    private String title;
    private String description;
    private Emotion emotion;
    private LocalDate momentDate;
    private boolean isGood;
    
    public AddMomentDTO(String title, String description, Emotion emotion, LocalDate momentDate, boolean isGood) {
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.momentDate = momentDate;
        this.isGood=isGood;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public LocalDate getMomentDate() {
        return momentDate;
    }

    public boolean getIsGood() {
        return isGood;
    }
    

    
}
