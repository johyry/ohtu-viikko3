package ohtu;

import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Submission {
    private int week;
    private int hours;
    private JsonArray excercises;
    private String course;
    
   

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public JsonArray getExcercises() {
        return excercises;
    }

    public void setExcercises(JsonArray excercises) {
        this.excercises = excercises;
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
        return course + ", " + week + " tehtyjä tehtäviä yhteensä: "
                + " aikaa kului: " + hours + " tehdyt tehtävät: " + excercises;
    }
    
}