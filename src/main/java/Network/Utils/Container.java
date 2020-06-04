package Network.Utils;

import java.io.IOException;
import java.util.Collection;

public interface Container<T> {

    String add(T element);
    void ud(int i, T element);
    void delete(int i) throws IOException;
    void printAll();
    void save();
    void load();


}
