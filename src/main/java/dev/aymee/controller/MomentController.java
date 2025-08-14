package dev.aymee.controller;
import java.time.LocalDate;
import dev.aymee.model.*;
import dev.aymee.repository.*;
import dev.aymee.view.*;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;


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
    
    public List<String> listMoments() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return repository.findAll()
                .stream()
                .map((Moment moment) -> {
                    String emotionFormatted =
                            String.valueOf(moment.getEmotion().name().charAt(0))
                            + moment.getEmotion().name().substring(1).toLowerCase();

                    return "Ocurrió el: " + moment.getMomentDate().format(formatter)
                            + ". Título: " + moment.getTitle()
                            + ". Descripción: " + moment.getDescription()
                            + ". Emoción: " + emotionFormatted;
                })
                .collect(Collectors.toList());
    }
}
 