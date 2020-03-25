package mathieu.pglp_5_1.dao;

import java.sql.Connection;

public abstract class Dao<T> {
    protected Connection connect;
    
    public abstract T create(T object);
    public abstract T find(String id);
    public abstract T update (T object);
    public abstract void delete(T object);
}
