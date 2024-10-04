package E7.IGeneric;

import java.util.List;

public interface IGeneral<T> {
    T getById(int var1);

    T getByCode(String var1);

    List<T> getByName(String var1);
}
