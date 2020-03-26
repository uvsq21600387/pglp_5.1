package mathieu.pglp_5_1.dao;

import java.util.ArrayList;
import java.util.Map;

public interface Dao<T> {
    
    public void add(T object);
    public T get(int id);
    public ArrayList<T> getAll();
    public T update(T object, Map<String,Object> params);
    public void remove(T object);
}
