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
    int movieYear;
    String movieRate;
    /**      */
    public GUI(){
        // Initializes the variables and UI aspects
        UI.initialise();
        //UI.addTextField("Search Title", this::searchMovie);
        UI.addTextField("Search Title/Director/Genre", this::searchEither);
        UI.addButton("Add Movie", this::newMovie);
        UI.addButton("Rate Movie", this::rateMovie);
        UI.addButton("Show All Movies", this::printAll);
        UI.addButton("Recommend Movies", this::recommendMovie);
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * A method to create a new movie
     */
    public void newMovie(){
        String movieName = UI.askString("Movie title: ");
        movieName = movieName.toLowerCase();        // Converts the title to lower case (Learnt on w3 Schools)
        while (again) {
            int movieYear = UI.askInt("Release Year: ");
            try{
                if(movieYear < 1880 || movieYear > 2030) {
                    throw new ArithmeticException();
                } else {
                    this.movieYear = movieYear;
                    again = false;
                }
            }
            
            catch(ArithmeticException ae) {
                UI.println("Please enter a year 1880-2030");
            }
            
            catch(Exception e) {
                UI.println("Please enter a year 1880-2030");
            }
        }
        again = true;
        String movieDirector = UI.askString("Director: ");
        movieDirector = movieDirector.toLowerCase();        // Converts the director to lower case (Learnt on w3 Schools)
        String movieGenre = UI.askString("Genre: ");
        movieGenre = movieGenre.toLowerCase();              // Converts the genre to lower case (Learnt on w3 Schools)
        r.addMovie(movieName, movieDirector, movieGenre, movieYear, movieNumber);
        this.movieNumber ++;
    }
    
    /**
     * Calls the method to show all the movies
     */
    public void printAll(){
        r.showAll();
    }
    
    /**
     * Calls the method to search for a movie
     */
    public void searchMovie(String search){
       //String search = UI.askString("Movie Title: ");
       search = search.toLowerCase();       // Converts the search to lower case
       r.searchMovie(search);
    }
    
    /**
     * Calls the method to search for the movies in a genre (OLD)
     */
    /*public void searchGenre(){
        String search = UI.askString("Genre: ");
        r.searchGenre(search);
    }*/
    
    /**
     * Calls the method to search for the movies by a director (OLD)
     */
    /*public void searchDirector(){
        String search = UI.askString("Director: ");
        r.searchDirector(search);
    }*/
    
    /**
     * Calls the method to search for either the movies by a director or in a genre
     */
    public void searchEither(String search){
        //String search = UI.askString("Director or Genre: ");
        search = search.toLowerCase();
        r.searchEither(search);
    }
    
    /**
     * Calls the method to rate a movie
     */
    public void rateMovie(){
        // Loop to check if the entered movie exists
        movieRate = UI.askString("Movie Title: ");
        movieRate = movieRate.toLowerCase();
        while (again) {
            // Checks if the movie exists
            if (r.movieExists(movieRate) == false){
                UI.println("That movie does not exist");
                movieRate = UI.askString("Movie Title: ");
            } else {
                again = false;
            }
        }
        again = true;
        // Loop to check if the rating is 0-10
        while (again) {
            double Rating = UI.askDouble("Rating: ");
            try{
                if(Rating < 0 || Rating > 10) {
                    throw new ArithmeticException();
                } else {
                    r.rateMovie(movieRate, Rating);
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
        again = true;
    }
    
    /**
     * Calls the method to recommend movies
     */
    public void recommendMovie(){
        r.recommendMovie();
    }

    public static void main(String[] args){
        GUI obj = new GUI();
    }

}

