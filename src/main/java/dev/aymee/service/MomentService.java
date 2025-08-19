package dev.aymee.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.List;

import dev.aymee.dto.AddMomentDTO;
import dev.aymee.model.Emotion;
import dev.aymee.model.Moment;
import dev.aymee.repository.MomentsRepository;

public class MomentService {
    private MomentsRepository repository;
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

        repository.addMoment(moment);
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
       
    boolean deleted = repository.deleteMoment(opcion);
    if (deleted) {
        return "Momento vivido eliminado correctamente";
    } else {
        return "El identificador proporcionado no existe en la lista";
    }
    }

    public List<String> filterByEmotion(Emotion emotion){
       return repository.filterByEmotion(emotion)
                .stream()
                .map(this::formatMoment) 
                .collect(Collectors.toList());

    }
     public List<String> filterByDate(LocalDate date){
         return repository.filterByDate(date)
                .stream()
                .map(this::formatMoment) 
                .collect(Collectors.toList());
    }
    public List<String> filterByCategory(boolean category){
         return repository.filterByCategory(category)
                .stream()
                .map(this::formatMoment) 
                .collect(Collectors.toList());
    }

}


