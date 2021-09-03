package Job4j.it.generics;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    private int indexOf(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if(id.equals(mem.get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = mem.indexOf(id);
        if(index!=-1) {
            mem.set(index, model);
            return true;
        }
       return false;
    }

    @Override
    public boolean delete(String id) {
        int index = mem.indexOf(id);
        if(index!=-1) {
            mem.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int index = mem.indexOf(id);
        if(index!=-1) {
           return mem.get(index);
        }
        return null;
    }
}
