package dev.aymee.repository;
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
public void saveCSV(List<Moment> list) {
    // TODO Auto-generated method stub
    
}


}
