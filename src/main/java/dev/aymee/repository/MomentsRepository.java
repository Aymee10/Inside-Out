package dev.aymee.repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import dev.aymee.model.*;

public class MomentsRepository {
    private List<Moment> momentList= new ArrayList<>();

    public void addMoment(Moment moment){
        momentList.add(moment);
    }

    public List<Moment> findAll() {
        return momentList;
    }

    public boolean deleteMoment(int id){
       
        return momentList.removeIf(m -> m.getId() == id);
    }
}
