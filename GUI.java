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
    public Integer movieNumber = 1;
    boolean again = true;
    /**      */
    public GUI(){
        UI.initialise();
        UI.addButton("Add", this::newMovie);
        UI.addButton("Search", this::searchMovie);
        /*UI.addButton("Search Genre", this::searchGenre);
        UI.addButton("Search Director", this::searchDirector);*/
        UI.addButton("Search Other", this::searchEither);
        /*UI.addButton("Rate", this::rateMovie);
        UI.addButton("Show All", this::printAll);*/
        UI.addButton("Quit", UI::quit);
    }
    
    public void newMovie(){
        String movieName = UI.askString("Movie title: ");
        int movieYear = UI.askInt("Release Year: ");
        String movieDirector = UI.askString("Director: ");
        String movieGenre = UI.askString("Genre: ");
        while (again) {
            double movieRating = UI.askDouble("Rating: ");
            try{
                if(movieRating < 0 || movieRating > 10) {
                    throw new ArithmeticException();
                } else {
                    r.addMovie(movieName, movieDirector, movieGenre, movieRating, movieYear, movieNumber);
                    again = false;
                }
            }
            
            catch(ArithmeticException ae) {
                UI.println("Please enter a number 0-10");
            }
            
            catch(Exception e) {
                UI.println("Please enter a number 0-10");
            }
        }
        this.movieNumber ++;
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
    
    public void searchEither(){
        String search = UI.askString("Director or Genre: ");
        r.searchEither(search);
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

