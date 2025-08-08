package dev.aymee.controller;
import java.time.LocalDate;
import dev.aymee.model.*;
import dev.aymee.repository.*;
import dev.aymee.view.*;

public class MomentController {
   
    private AddMomentView addMomentView;
    private MomentsRepository repository;

    public MomentController(AddMomentView addMomentView, MomentsRepository repository) {
        this.addMomentView = addMomentView;
        this.repository = repository;
    }

    public String addMoment(){
        try{
        int id=repository.findAll().size()+1;
        String title=addMomentView.askTitle();
        String description=addMomentView.askDescription();
        Emotion emotion=addMomentView.askEmotion();
        LocalDate date=addMomentView.askDate();

        Moment moment=new  Moment(id, title, description, emotion, date);
        repository.addMoment(moment);
        return "Momento añadido correctamente";
        }
        catch(Exception e){
          return "Error al añadir el momento: " + e.getMessage();
        }
    }
}
