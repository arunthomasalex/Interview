package org.example.tutorial.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements Sort {
    private List<Integer> data;
    private List<Integer> result;

    public QuickSort(List<Integer> data) {
        this.data = data;
    }

    @Override
    public void sort() {
        this.result = iteration(data);
    }

    private List<Integer> iteration(List<Integer> data) {
        if(data.size() > 1) {
            int pivot = data.size() / 2;
            Integer temp;
            for(int i = 0; i < pivot; i++) {
                if(data.get(pivot) < data.get(i)) {
                    temp = data.get(pivot);
                    data.set(pivot, data.get(i));
                    data.set(i, temp);
                }
            }
            for(int i = (pivot + 1); i < data.size(); i++) {
                if(data.get(pivot) > data.get(i)) {
                    temp = data.get(pivot);
                    data.set(pivot, data.get(i));
                    data.set(i, temp);
                }
            }
            List<Integer> firstHalf = iteration(data.subList(0, pivot));
            List<Integer> secondHalf = iteration(data.subList(pivot, data.size()));
            int firstLength = firstHalf.size(), secondLength = secondHalf.size();
            List<Integer> result = new ArrayList<>();
            int i = 0, j = 0, k = 0;
            while(i < firstLength && j < secondLength) {
                if(firstHalf.get(i) < secondHalf.get(j)) {
                    result.add(k++, firstHalf.get(i++));
                } else {
                    result.add(k++, secondHalf.get(j++));
                }
            }
            while(i < firstLength) {
                result.add(k++, firstHalf.get(i++));
            } 
            while(j < secondLength) {
                result.add(k++, secondHalf.get(j++));
            }
            return result;
        }
        return data;
    }

    @Override
    public List<Integer> result() {
        return result;
    }
    
}
