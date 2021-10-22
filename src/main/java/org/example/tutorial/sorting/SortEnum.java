package org.example.tutorial.sorting;

public enum SortEnum {
    QUICK_SORT("QuickSort");
    private String name;
    SortEnum(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
