package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Person> listOfMen = null;
    ArrayList<Person> listOfWomen = null;
    ArrayList<Integer> tempPrefList = null;
    int womenCounter = 2;
    int menCounter = 1;
    int number = 0;
        while(scan.hasNext()){
            //Get the line
            String line = scan.nextLine();

            //discard empty lines.
            if(line.isEmpty() == true){
                continue;
            }

            //Discard commented lines.
            if(line.charAt(0) == '#') {
                System.out.println("Skipping comment");
                continue;
            }

            //get the number of pairs (n=number)
            if(line.charAt(0) == 'n') {
                String n = line.substring(2);
                number = Integer.parseInt(n);
                listOfMen = new ArrayList<Person>(number);
                listOfWomen = new ArrayList<Person>(number);
                tempPrefList = new ArrayList<Integer>(number);
                System.out.println("n= " + n);
                continue;
            }

            //put each word from line in array of strings
            String[] tokens = line.split(" ");

            //get person
            //if true, its a even number i.e. woman
            //otherwise, if its a odd number its a man
            //also checks the first entry to be only numbers
            //to be able to differ "1 Ross" from "1: 1 2 3"
            if(tokens[0].matches("\\d+") && Integer.parseInt(tokens[0]) % 2 == 0){
                System.out.println("Add " + tokens[1] + " to List of Women");
                listOfWomen.add(new Person(tokens[1]));
            }else if(tokens[0].matches("\\d+") && Integer.parseInt(tokens[0]) % 2 != 0 ){
                System.out.println("Add " + tokens[1] + " to List of Men");
                listOfMen.add(new Person(tokens[1]));
            }

            //get preference list by looking att first entry
            //in tokens and looking for "x:" to know its is the
            //right line.
            if(tokens[0].matches("\\d+(:)")){
                int index = Integer.parseInt(tokens[0].substring(0, tokens[0].length() - 1));
                System.out.println("Index is: " + index);
                for(int i = 1; i < tokens.length; i++){
                    tempPrefList.add(Integer.parseInt(tokens[i]));
                    System.out.println("Adding: " + Integer.parseInt(tokens[i]) + " to preference list");
                }
                if(index % 2 == 0) {
                    System.out.println(index - womenCounter);
                    listOfWomen.get(index - womenCounter).setPreferenceList(tempPrefList);
                    womenCounter++;
                } else if (index % 2 != 0){
                    System.out.println(index - menCounter);
                    listOfMen.get(index - menCounter).setPreferenceList(tempPrefList);
                    menCounter++;
                }
            }
        //clear the tempPrefList for the new iteration
        tempPrefList = new ArrayList<>(number);
        }
        for(Person p : listOfMen){
            System.out.println("Person: " + p.getName() + " with prefList: " + p.toString());
        }
        for(Person p : listOfWomen){
            System.out.println("Person: " + p.getName() + " with prefList: " + p.toString());
        }
    }
}
