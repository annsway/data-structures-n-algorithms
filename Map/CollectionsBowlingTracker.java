// This is one of my assignments from the course ELENGX436.2-015 Java: Discovering Its Power
// that I took at University of California-Berkeley Extension
//
// Rules:
// Use the collections framework and generic types to create a bowling score tracker collection.
// Design a data structure that will be used as elements in a collection.
//
// Each element should contain
// (1) a unique name of the bowler and
// (2) a list of scores and dates of the games they have played.
//
// Then print to the screen each:
// (1) Bowler name
// (2) Number of games
// (3) Average score of all of the games
// (4) Score of their last game
// (5) Date of their last game

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CollectionsBowlingTracker {

    String name;
    HashMap<Date, Double> bowlingTracker;

    public static void main(String[] args) throws ParseException {

        ////// Player A
        CollectionsBowlingTracker playerA = new CollectionsBowlingTracker("Ann");

        playerA.addGame("01/01/2020", 10.0);
        playerA.addGame("02/01/2020", 9.0);
        playerA.addGame("03/01/2020", 9.5);
        playerA.addGame("03/15/2020", 8.9);


        System.out.println("Bowler name: "+playerA.getName());
        System.out.println("Number of games: "+playerA.bowlingTracker.size());
        System.out.println("The average score of the games is "+playerA.getAvgScore());
        System.out.println("The score of the last game is "+playerA.getLastScore());
        System.out.println("The date of the last game is "+playerA.getLastDate());

        System.out.println("\n");

        ////// Player B
        CollectionsBowlingTracker playerB = new CollectionsBowlingTracker("Steve");

        playerB.addGame("01/01/2020", 9.0);
        playerB.addGame("02/01/2020", 8.5);
        playerB.addGame("03/01/2020", 9.9);

        System.out.println("Bowler name: "+playerB.getName());
        System.out.println("Number of games: "+playerB.bowlingTracker.size());
        System.out.println("The average score of the games is "+playerB.getAvgScore());
        System.out.println("The score of the last game is "+playerB.getLastScore());
        System.out.println("The date of the last game is "+playerB.getLastDate());


    }

    CollectionsBowlingTracker(String name){
        this.name = name;
        bowlingTracker = new HashMap<>();

    }

    public String getName(){
        return this.name;
    }

    public void addGame(String inputDate, Double score) throws ParseException {

        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(inputDate);
        bowlingTracker.put(date, score);
    }

    public Double getAvgScore(){

        Double totalScore=0.0;
        Set<Date> keys = bowlingTracker.keySet();

        for (Date key:keys){
            totalScore = totalScore + bowlingTracker.get(key);
        }

        Double avgScore = totalScore/bowlingTracker.size();

        return avgScore;

    }

    public Date getLastDate(){

        List<Date> dates = new ArrayList<>();
        Set<Date> keys = bowlingTracker.keySet();

        for (Date key:keys){
            dates.add(key);
        }

        return Collections.max(dates);

    }

    public Double getLastScore(){

        return bowlingTracker.get(getLastDate());

    }



}

