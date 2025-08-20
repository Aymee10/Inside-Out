package dev.aymee.repository;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import dev.aymee.model.*;

public class MomentsRepository implements Repository<Moment> {
    private List<Moment> momentList= new ArrayList<>();

    @Override
    public void add(Moment moment){
        momentList.add(moment);
    }

    @Override
    public List<Moment> findAll() {
        return momentList;
    }

    @Override
    public boolean delete(int id){
       
        return momentList.removeIf(m -> m.getId() == id);
    }
    
@Override
public String saveCSV(List<Moment> list) {
    String folder="data";
    String file=folder + "/moments.csv";

    File directory=new File(folder);
        if(!directory.exists()){
            directory.mkdirs();
        }
    
    try(FileWriter writer=new FileWriter(file)){
        writer.write("id,title,description,emotion,momentDate,isGood,modifiedDate\n");
        for(Moment m:list){
            writer.write(m.getId()+","+
            m.getTitle()+","+
            m.getDescription()+","+
            m.getEmotion().name()+","+
            m.getMomentDate()+","+
            m.isGood()+","+
            m.getModifiedDate()
           
            );
        }
        return ("Datos guardados en :"+ file);
    }

    catch (Exception e) {
       return( "Error al guardar: "+ e.getMessage());
    }
}


}
