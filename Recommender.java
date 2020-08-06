import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * The class that contains all of the main methods for the program such as adding as movie
 * 
 * @author Jarvis Warnock
 * @version 2
 */
public class Recommender
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Movie> movieRecommendations;
    private String movieName;
    private String movieDirector;
    private String movieGenre;
    private double movieRating;
    private boolean movieExists;

    /**
     * Constructor for objects of class Recommender
     */
    public Recommender()
    {
        // initialise instance variables
        movieRecommendations = new HashMap<Integer, Movie>();
        
    }

    /**
     * A method to add a movie to the hashmap
     * 
     * @param       movieName - the name of the movie
     * @param       movieDirector - the director of the movie
     * @param       movieGenre - the genre of the movie
     * @param       movieRating - the rating of the movie
     * 
     * @return      void 
     */
    public void addMovie(String movieName, String movieDirector, String movieGenre, double movieRating, int movieYear, Integer movieNumber)
    {
        // put your code here
        movieRecommendations.put(movieNumber, new Movie(movieName, movieDirector, movieGenre, movieRating, movieYear));
    }
    
    public void searchMovie(String search){
        movieExists = false;
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getName().equals(search)){
                UI.println("-------------------------------------");
                UI.println("Title: " + movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                UI.println("Director: " + movieRecommendations.get(key).getDirector());
                UI.println("Genre: " + movieRecommendations.get(key).getGenre());
                UI.println("Rating: " + movieRecommendations.get(key).getRating());
                movieExists = true;
            }
        }
        if (movieExists == false){
            UI.println("That movie could not be found");
        }
    }
    
    public void searchGenre(String search){
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getGenre().equals(search)){
                UI.println("-------------------------------------");
                UI.println("Title: " + movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                UI.println("Director: " + movieRecommendations.get(key).getDirector());
                UI.println("Genre: " + movieRecommendations.get(key).getGenre());
                UI.println("Rating: " + movieRecommendations.get(key).getRating());
            }
        }
    }
    
    public void searchDirector(String search){
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getDirector().equals(search)){
                UI.println("-------------------------------------");
                UI.println("Title: " + movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                UI.println("Director: " + movieRecommendations.get(key).getDirector());
                UI.println("Genre: " + movieRecommendations.get(key).getGenre());
                UI.println("Rating: " + movieRecommendations.get(key).getRating());
            }
        }
    }
    
    public void searchEither(String search){
        movieExists = false;
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getDirector().equals(search)||movieRecommendations.get(key).getGenre().equals(search)){
                UI.println("-------------------------------------");
                UI.println("Title: " + movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                UI.println("Director: " + movieRecommendations.get(key).getDirector());
                UI.println("Genre: " + movieRecommendations.get(key).getGenre());
                UI.println("Rating: " + movieRecommendations.get(key).getRating());
                movieExists = true;
            }
        }
        if (movieExists == false){
            UI.println("A movie with that director/genre could not be found");
        }
    }
    
    public void showAll(){
        for (Integer key : movieRecommendations.keySet()){
            UI.println("Title: " + movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
            UI.println("Director: " + movieRecommendations.get(key).getDirector());
            UI.println("Genre: " + movieRecommendations.get(key).getGenre());
            UI.println("Rating: " + movieRecommendations.get(key).getRating());
        }
    }
    
    public void rateMovie(String movieRate, double newRating){
        movieRecommendations.get(movieRate).changeRating(newRating);
    }
}
