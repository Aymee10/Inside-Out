package dev.aymee.controller;
import dev.aymee.service.MomentService;
import dev.aymee.view.*;
import java.util.List;
import dev.aymee.dto.AddMomentDTO;

public class MomentController {
   
    private AddMomentView addMomentView;
    private MomentService momentService;
    private DeleteMomentView deleteView;
    private FilterMomentsListView filterView;

    public MomentController(AddMomentView addMomentView, MomentService momentService, DeleteMomentView deleteMomentView, FilterMomentsListView filterView) {
        this.addMomentView = addMomentView;
        this.momentService = momentService;
        this.deleteView=deleteMomentView;
        this.filterView= filterView;
      
    }

    public String addMoment(){
        try{
        AddMomentDTO dto = new AddMomentDTO(
                addMomentView.askTitle(),
                addMomentView.askDescription(),
                addMomentView.askEmotion(),
                addMomentView.askDate()
            );
        momentService.addMoment(dto);    
        return "Momento añadido correctamente";
        }
        catch(Exception e){
          return "Error al añadir el momento: " + e.getMessage();
        }
    }
    
    public List<String> listMoments() {
        return momentService.listMoments();
    }

    public String deleteMoment(){
       int opcion=deleteView.delete();
       
       return momentService.deleteMoment(opcion);
      
       }
    }

 