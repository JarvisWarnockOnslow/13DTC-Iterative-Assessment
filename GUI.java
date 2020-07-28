/* Based on the ecs 100 template
 * Code for ??
 * Name:
 * Date:
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** Creates the GUI for the movie recommender
 */
public class GUI{
    private Recommender r = new Recommender();
    /**      */
    public GUI(){
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.addButton("Add", this::newMovie);
        UI.addButton("Search", this::searchMovie);
        UI.addButton("Search Genre", this::searchGenre);
        UI.addButton("Search Director", this::searchDirector);
        /*UI.addButton("Rate", this::rateMovie);
        UI.addButton("Show All", this::printAll);*/
    }
    
    public void newMovie(){
        String movieName = UI.askString("Movie title: ");
        String movieDirector = UI.askString("Director: ");
        String movieGenre = UI.askString("Genre: ");
        double movieRating = UI.askDouble("Rating: ");
        r.addMovie(movieName, movieDirector, movieGenre, movieRating);
    }

    public void printAll(){
        r.showAll();
    }
    
    public void searchMovie(){
       String search = UI.askString("Movie Title: ");
       r.searchMovie(search);
    }
    
    public void searchGenre(){
        String search = UI.askString("Genre: ");
        r.searchGenre(search);
    }
    
    public void searchDirector(){
        String search = UI.askString("Director: ");
        r.searchDirector(search);
    }
    
    public void rateMovie(){
        String movieRate = UI.askString("Movie Title: ");
        double newRating = UI.askDouble("New Rating: ");
        r.rateMovie(movieRate, newRating);
    }

    public static void main(String[] args){
        GUI obj = new GUI();
    }

}

