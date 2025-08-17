package dev.aymee.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.List;

import dev.aymee.dto.AddMomentDTO;
import dev.aymee.model.Moment;
import dev.aymee.repository.MomentsRepository;

public class MomentService {
    private MomentsRepository repository;

    public MomentService(MomentsRepository repository) {
        this.repository = repository;
    }

    public void addMoment(AddMomentDTO dto) {
        int id = repository.findAll().size() + 1;

        Moment moment = new Moment(
            id,
            dto.getTitle(),
            dto.getDescription(),
            dto.getEmotion(),
            dto.getMomentDate()
        );
      
        moment.setModifiedDate(LocalDate.now());

        repository.addMoment(moment);
    }

    public List<String> listMoments() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return repository.findAll()
                .stream()
                .map(moment -> {
                    String emotionFormatted =
                            moment.getEmotion().name().charAt(0) +
                            moment.getEmotion().name().substring(1).toLowerCase();

                    return "Ocurrió el: " + moment.getMomentDate().format(formatter)
                            + ". Título: " + moment.getTitle()
                            + ". Descripción: " + moment.getDescription()
                            + ". Emoción: " + emotionFormatted;
                })
                .collect(Collectors.toList());
    }
}


