package com.company;
import java.util.*;
/**
 * Created by Johannes on 2016-03-22.
 */
public class Person {
    String name;
    boolean free;
    ArrayList<Integer> preferenceList;

    public Person(String name){
        this.name = name;
        // kommer nog initieras i parser preferenceList = new ArrayList<Integer>(size);
        free = true;
    }

    public boolean isFree(){
        return free;
    }

    public void setFreenes(boolean free){
        this.free = free;
    }

    public String getName(){
        return name;
    }

    public void setPreferenceList(ArrayList<Integer> theList){
        preferenceList = theList;
    }

    public ArrayList<Integer> getPreferenceList(){
        return preferenceList;
    }

    @Override public String toString(){
        String result = "";
        if(preferenceList.isEmpty()){
            return "List is empty";
        }
        for (int i : preferenceList){
            result += Integer.toString(i) + " ";
        }
        return result;
    }
}
