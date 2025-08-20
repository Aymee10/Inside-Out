package dev.aymee.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.List;
import dev.aymee.dto.AddMomentDTO;
import dev.aymee.model.Emotion;
import dev.aymee.model.Moment;
import dev.aymee.repository.*;

public class MomentService {
    private Repository<Moment> repository;
    private int  id;
     private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MomentService(MomentsRepository repository) {
        this.repository = repository;
        this.id=0;
    }

    public void addMoment(AddMomentDTO dto) {
         id ++;

        Moment moment = new Moment(
            id,
            dto.getTitle(),
            dto.getDescription(),
            dto.getEmotion(),
            dto.getMomentDate(),
            dto.getIsGood()
        );
      
        moment.setModifiedDate(LocalDate.now());

        repository.add(moment);
    }
private String formatMoment(Moment moment) {
        String emotionFormatted =
                moment.getEmotion().name().charAt(0) +
                moment.getEmotion().name().substring(1).toLowerCase();
        String category;
        if(moment.isGood()){
            category="Bueno";
        }    else{
            category="Malo";
        }    

        return moment.getId() + "-" +
                "Ocurrió el: " + moment.getMomentDate().format(formatter) +
                ". Título: " + moment.getTitle() +
                ". Descripción: " + moment.getDescription() +
                ". Emoción: " + emotionFormatted +
                ". Categoría: "+ category;

    }
    public List<String> listMoments() {
        return repository.findAll()
                .stream()
                .map(this::formatMoment) 
                .collect(Collectors.toList());
    }
    public String deleteMoment(int opcion){
       
    boolean deleted = repository.delete(opcion);
    if (deleted) {
        return "Momento vivido eliminado correctamente";
    } else {
        return "El identificador proporcionado no existe en la lista";
    }
    }

    public List<String> momentsToStrings(List<Moment> listMoments){
        return  listMoments.stream()
                .map(this::formatMoment) 
                .collect(Collectors.toList());
    }

    public List<String> filterByEmotion(Emotion emotion) {
        List<Moment> momentList=repository.findAll();
        List<Moment> filteredList= momentList.stream()
            .filter(m -> m.getEmotion() == emotion)
            .toList(); 

             return  momentsToStrings(filteredList);

    }

     public List<String> filterByDate(LocalDate date){
         List<Moment> momentList=repository.findAll();
         List<Moment> filteredList= momentList.stream()
           .filter(m -> m.getMomentDate().equals(date))
            .toList(); 

             return  momentsToStrings(filteredList);
    }
    public List<String> filterByCategory(boolean category){
         List<Moment> momentList=repository.findAll();
         List<Moment> filteredList= momentList.stream()
            .filter(m -> m.isGood()==category)
            .toList(); 

             return  momentsToStrings(filteredList);
    }

}


