package dev.aymee.controller;
import dev.aymee.service.MomentService;
import dev.aymee.view.*;

import java.time.LocalDate;
import java.util.List;
import dev.aymee.dto.AddMomentDTO;
import dev.aymee.model.Emotion;

public class MomentController {
   
    private AddMomentView addMomentView;
    private MomentService momentService;
    private DeleteMomentView deleteView;
    private FilterMomentsListView filterView;
    private FilterByEmotionView filteByEmotionView;
    private FilterByDateView filterByDateView;
    private FilterByCategoryView filterByCategoryView;

    public MomentController(AddMomentView addMomentView, MomentService momentService, DeleteMomentView deleteMomentView, FilterMomentsListView filterView, FilterByEmotionView filterEmotionView, FilterByDateView filterDateView, FilterByCategoryView filterByCategoryView) {
        this.addMomentView = addMomentView;
        this.momentService = momentService;
        this.deleteView=deleteMomentView;
        this.filterView= filterView;
        this.filteByEmotionView=filterEmotionView;
        this.filterByDateView=filterDateView;
        this.filterByCategoryView=filterByCategoryView;

      
    }

    public String addMoment(){
        try{
        AddMomentDTO dto = new AddMomentDTO(
                addMomentView.askTitle(),
                addMomentView.askDescription(),
                addMomentView.askEmotion(),
                addMomentView.askDate(),
                addMomentView.askIfIsGood()
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

       public List<String> filterMoments(){
        int option=filterView.filterMoments();
        switch (option) {
            case 1:{
                Emotion selectedEmotion= filteByEmotionView.filterEmotion();
                 return   momentService.filterByEmotion(selectedEmotion);
                }
              case 2:{
                LocalDate selectedlDate= filterByDateView.filterDate();
                return  momentService.filterByDate(selectedlDate);
        }   
        case 3:{
          boolean category=filterByCategoryView.filterCategory();   
          return momentService.filterByCategory(category); 
        }  
            default:
                return List.of("Opción no válida");
        }
                 
       }
       public String saveCSV(){
        return momentService.saveCSV();
       }
    }

 