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
       boolean deleted=false;
       
       Iterator <Moment> iterator=momentList.iterator();
       while (iterator.hasNext()) {
        Moment m=iterator.next();
        if (m.getId()==id){
            iterator.remove();
            deleted=true;
        }
       }
        return deleted;
    }
}
