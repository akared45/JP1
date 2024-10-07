package E9.General;

import java.util.List;

public interface IGeneric<T> {
    void update(T object);
    List<T> sort(List<T> items);
    T findById(int id);
}
