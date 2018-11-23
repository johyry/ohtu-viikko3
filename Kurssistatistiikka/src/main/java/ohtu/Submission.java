package ohtu;

import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Submission {
    private int week;
    private int hours;
    private ArrayList<Integer> exercises;
    private String course;
    
   

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public int getNumberOfExercises() {
        return exercises.size();
    }
    
    

    public ArrayList<Integer> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Integer> exercises) {
        this.exercises = exercises;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    @Override
    public String toString() {
        String tehtavat = "";
        
        for (int i = 0; i < exercises.size(); i++) {
            tehtavat = tehtavat + exercises.get(i) + ", ";
        }
        
        return course + ", " + week + " tehtyjä tehtäviä yhteensä: "
                + " aikaa kului: " + hours + " tehdyt tehtävät: " + tehtavat;
    }
    
}