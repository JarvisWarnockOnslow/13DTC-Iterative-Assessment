import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * The class that contains all of the main methods for the program such as adding as movie
 * 
 * @author Jarvis Warnock
 * @version 1
 */
public class Recommender
{
    // instance variables - replace the example below with your own
    private HashMap<String, Movie> movieRecommendations;

    /**
     * Constructor for objects of class Recommender
     */
    public Recommender()
    {
        // initialise instance variables
        movieRecommendations = new HashMap<String, Movie>();
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
    public void addMovie(String movieName, String movieDirector, String movieGenre, double movieRating)
    {
        // put your code here
        movieRecommendations.put(movieName, new Movie(movieName, movieDirector, movieGenre, movieRating));
    }
    
    public void printDirector(String movie){
        String director = movieRecommendations.get(movie).getDirector();
        System.out.println(director);
    }
}
