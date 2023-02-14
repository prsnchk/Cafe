package dao;

import java.util.List;

public interface Dao <E, K> {
    public abstract List<E> getAll();
    public abstract E getEntityById(K id);
    public abstract void update(E entity);
    public abstract void delete(K id);
    public abstract void save(E entity);
}
