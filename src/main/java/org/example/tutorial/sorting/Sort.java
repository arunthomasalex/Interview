package org.example.tutorial.sorting;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Sort {
    public void sort();

    public List<Integer> result();

    static Map<SortEnum, Class<?>> sortClass = new HashMap<>();

    static Sort getInstance(SortEnum sortType, List<Integer> data) {
        if (data != null && data.size() > 0) {
            try {
                if(!sortClass.containsKey(sortType)) {
                    sortClass.put(sortType, Class.forName("org.example.tutorial.sorting." + sortType.getName()));
                }
                Class<?> sort = sortClass.get(sortType);
                return (Sort) sort.getConstructor(List.class).newInstance(data);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }
            return null;
        }
        throw new RuntimeException("Data not valid.");
    }
}
