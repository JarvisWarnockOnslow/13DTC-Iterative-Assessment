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
    private String movieName;
    private String movieDirector;
    private String movieGenre;
    private double movieRating;

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
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Movie Name: ");
        movieName = scan.nextLine();
        System.out.println("Movie Director: ");
        movieDirector = scan.nextLine();
        System.out.println("Movie Genre: ");
        movieGenre = scan.nextLine();
        System.out.println("Movie Rating (1-10): ");
        movieRating = scan.nextDouble();*/
        movieRecommendations.put(movieName, new Movie(movieName, movieDirector, movieGenre, movieRating));
    }
    
    public void searchMovie(String search){
        movieRecommendations.get(search).getName();
        String movieDirector = movieRecommendations.get(search).getDirector();
        String movieGenre = movieRecommendations.get(search).getGenre();
        double movieRating = movieRecommendations.get(search).getRating();
        UI.println("Title: "+search);
        UI.println("Director: "+movieDirector);
        UI.println("Genre: "+movieGenre);
        UI.println("Rating: "+movieRating);
    }
    
    public void showAll(){
        for (String key : movieRecommendations.keySet()){
            UI.println(key);
            UI.println(movieRecommendations.get(key).getDirector());
            UI.println(movieRecommendations.get(key).getGenre());
            UI.println(movieRecommendations.get(key).getRating());
        }
    }
    
    /*public void rateMovie(String movieRate, double newRating){
        movieRecommendations.get(movieRate).changeRating(newRating);
    }*/
}
