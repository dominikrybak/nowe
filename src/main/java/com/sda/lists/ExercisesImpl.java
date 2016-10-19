package com.sda.lists;

import java.util.ArrayList;
import java.util.List;

public class ExercisesImpl {

    public static List<String> fill(String string, int size) {
    	List<String> filled = new ArrayList<String>();
    	 for(int i = 0; i < size; i++){
    		 filled.add(string);
    	 }
		return filled;
    }
    public static <T> List<T> fillGeneric(T value, int size) {
    	List<T> filled = new ArrayList<T>();
    	for(int i = 0; i< size; i++){
    		filled.add(value);
    	}
        return filled;
    }
    public static void swap(List<String> listOne, int i, int j) {
    		String x = listOne.get(i);
    		String y = listOne.get(j);
    		listOne.remove(i);
    		listOne.add(i,y);
    		listOne.remove(j);
    		listOne.add(j, x);
    }

    public static <T> void swapGeneric(List<T> listOne, int i, int j) {
    	T valueAtI = listOne.get(i);
        T valueAtJ = listOne.get(j);
        
        listOne.remove(i);
        listOne.add(i, valueAtJ);
        listOne.remove(j);
        listOne.add(j, valueAtI);
    }

    public static void reverse(List<String> list) {
    	List<String> reversedList = new ArrayList<String>();
    	for (int i = list.size()-1; i >= 0;i--){
    		reversedList.add(list.get(i));
    	}
    	list.clear();
    	list.addAll(reversedList);
    }

    public static <T> void reverseGeneric(List<T> list) {
    }

    public static void rotate(List<Integer> numbers, int i) {
    }

    public static void bubbleSort(ArrayList<Integer> list) {
    }

}
