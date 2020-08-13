import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * The class that contains all of the main methods for the program such as adding as movie
 * 
 * @author Jarvis Warnock
 * @version 3
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
    private static final int recommendLength = 11;
    private String[] recommendDirector;
    private String[] recommendGenre;
    private int i = 0;
    

    /**
     * Constructor for objects of class Recommender
     */
    public Recommender()
    {
        // initialise instance variables
        movieRecommendations = new HashMap<Integer, Movie>();
        recommendDirector = new String[recommendLength];
        recommendGenre = new String[recommendLength];
        
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
    public void addMovie(String movieName, String movieDirector, String movieGenre, int movieYear, Integer movieNumber)
    {
        // adds a movie to the hashmap with the variables provided form the GUI class
        movieRecommendations.put(movieNumber, new Movie(movieName, movieDirector, movieGenre, movieYear));
    }
    
    /**
     * A method to search for a movie in the hashmap
     * 
     * @param       search - the name of the movie that the user ants to search for
     * 
     * @return      void
     */
    public void searchMovie(String search){
        //A vaiable to check if there is at least one movie that exists with the name searched for
        if (movieExists(search) == false){
            // If no movie with the name searched exists return the error
            UI.println("That movie could not be found");
        } else {
            for (Integer key : movieRecommendations.keySet()){      // Loops through the hashmap
                if (movieRecommendations.get(key).getName().equals(search)){        // Checks if the movie has the same name as the one searched for
                    // Prints out the details about the movie if it matches the search
                    UI.println("-------------------------------------");
                    UI.println("Title: " + movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                    UI.println("Director: " + movieRecommendations.get(key).getDirector());
                    UI.println("Genre: " + movieRecommendations.get(key).getGenre());
                    if (movieRecommendations.get(key).getRating() != -1){
                        UI.println("Rating: " + movieRecommendations.get(key).getRating());
                    }
                    // Sets it to true because at least one movie with that name exists
                }
            }
        }
    }
    
    
    public void searchGenre(String search){
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getGenre().equals(search)){
                UI.println("-------------------------------------");
                UI.println("Title: " + movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                UI.println("Director: " + movieRecommendations.get(key).getDirector());
                UI.println("Genre: " + movieRecommendations.get(key).getGenre());
                if (movieRecommendations.get(key).getRating() != -1){
                    UI.println("Rating: " + movieRecommendations.get(key).getRating());
                }
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
                if (movieRecommendations.get(key).getRating() != -1){
                    UI.println("Rating: " + movieRecommendations.get(key).getRating());
                }
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
                if (movieRecommendations.get(key).getRating() != -1){
                    UI.println("Rating: " + movieRecommendations.get(key).getRating());
                }
                movieExists = true;
            }
        }
        if (movieExists == false){
            UI.println("A movie with that director/genre could not be found");
        }
    }
    
    /**
     * A method to print all of the movies in the hashmap
     * 
     * @param       none
     * 
     * @return      void
     */
    public void showAll(){
        for (Integer key : movieRecommendations.keySet()){
            UI.println("-------------------------------------");
            UI.println("Title: " + movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
            UI.println("Director: " + movieRecommendations.get(key).getDirector());
            UI.println("Genre: " + movieRecommendations.get(key).getGenre());
            if (movieRecommendations.get(key).getRating() != -1){
                UI.println("Rating: " + movieRecommendations.get(key).getRating());
            }
        }
    }
    
    /**
     * A method to rate/change the rating of a movie
     * 
     * @param       movieRate - the movie that is being rated
     * @param       newRating - the new rating for the movie
     * 
     * @return      void
     */
    public void rateMovie(String movieRate, double Rating){
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getName().equals(movieRate)){
                movieRecommendations.get(key).changeRating(Rating);
            }
        }
    }
    
    public boolean movieExists(String movieName){
        movieExists = false;
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getName().equals(movieName)){
                movieExists = true;
            }
        }
        return (movieExists);
    }
    
    /**
     * A method to recommend movies based on previous ratings
     * 
     * 
     * 
     * @return      void
     */
    public void recommendMovie(){
        // Adds the directors of highly rated movies to an array
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getRating() > 6){     // Checks if the movies rating is greater than 6
                if (!Arrays.asList(recommendDirector).contains(movieRecommendations.get(key).getDirector())){       // Learnt on w3 schools
                    recommendDirector[i] = movieRecommendations.get(key).getDirector();
                }   
                if (!Arrays.asList(recommendGenre).contains(movieRecommendations.get(key).getGenre())){       // Learnt on w3 schools
                    recommendGenre[i] = movieRecommendations.get(key).getGenre();
                }
                if (i <= 10){
                    i++;
                }
            }
        }
        // Prints out movies that have the same director as highly rated movies
        UI.println("Movies that you may like: ");
        for (String director : recommendDirector){
            for (Integer key : movieRecommendations.keySet()){
                if (movieRecommendations.get(key).getDirector().equals(director) && movieRecommendations.get(key).getRating() == -1){
                    UI.println(movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                }
            }
        }
        for (String genre : recommendGenre){
            for (Integer key : movieRecommendations.keySet()){
                if (movieRecommendations.get(key).getGenre().equals(genre) && movieRecommendations.get(key).getRating() == -1){
                    UI.println(movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                }
            }
        }
    }
}
