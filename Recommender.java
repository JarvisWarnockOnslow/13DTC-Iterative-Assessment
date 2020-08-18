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
    private static final int recommendLength = 10;
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
        UI.println("Movie Added");
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
    
    /**
     * An old method to search just for the movies in a genre
     * 
     * @ param      search - the genre to show the movies from
     * 
     * @ return void
     */
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
    
    /**
     * An old method to search just for the movies by a specific director
     * 
     * @ param      search - the director to show the movies from
     * 
     * @ return     void  
     */
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
    
    /**
     * A method to search for either a director or genre
     * 
     * @ param      search - The director or genre to search for
     * 
     * @ return     void
     */
    public void searchEither(String search){
        movieExists = false;
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getDirector().equals(search)||movieRecommendations.get(key).getGenre().equals(search) ||movieRecommendations.get(key).getName().equals(search)){
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
            UI.println("A movie with that title/director/genre could not be found");
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
                UI.println("Movie Rated");
            }
        }
    }
    
    /**
     * A method to check if a movie exists (for the search and rating methods)
     * 
     * @ param      movieName - the name of the movie to check for
     * 
     * @ return     if the movie exists or not
     */
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
     * Recommends movies that have not been rated by the same director or in the same genre as ones you have rated highly 
     * 
     * @ param       none
     * 
     * @ return      void
     */
    public void recommendMovie(){
        // Adds the directors and genres of highly rated movies to an array
        for (Integer key : movieRecommendations.keySet()){
            if (movieRecommendations.get(key).getRating() > 6){     // Checks if the movies rating is greater than 6
                if (!Arrays.asList(recommendDirector).contains(movieRecommendations.get(key).getDirector())){       // Learnt on w3 schools
                    recommendDirector[i] = movieRecommendations.get(key).getDirector();
                }
                if (!Arrays.asList(recommendGenre).contains(movieRecommendations.get(key).getGenre())){       // Learnt on w3 schools
                    recommendGenre[i] = movieRecommendations.get(key).getGenre();
                }
                // Stops after 10 else there may be too many movies recommended
                if (i <= 10){
                    i++;
                }
            }
        }
        // Checks if the lists are empty (to tell the user that there are none to recommend)
        if (recommendDirector[0] == null && recommendGenre[0] == null){
            UI.println("There are no movies to recommend (Try add some more)");
        } else {
            UI.println("Movies that you may like: ");
        }
        // Prints out all of the movies in the list
        for (String director : recommendDirector){
            for (Integer key : movieRecommendations.keySet()){
                if (movieRecommendations.get(key).getDirector().equals(director) && movieRecommendations.get(key).getRating() == -1){
                    UI.println(movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                    movieRecommendations.get(key).changePrinted(true);      // Sets the printed to true so it doesnt print again if the movie has the same genre and director as a high rated one
                }
            }
        }
        for (String genre : recommendGenre){
            for (Integer key : movieRecommendations.keySet()){
                if (movieRecommendations.get(key).getGenre().equals(genre) && movieRecommendations.get(key).getRating() == -1 && movieRecommendations.get(key).getPrinted() == false){
                    UI.println(movieRecommendations.get(key).getName() + " (" + movieRecommendations.get(key).getYear() + ")");
                    movieRecommendations.get(key).changePrinted(false);
                }
            }
        }
        // Empties the arrays after the recommended movies have been printed
        Arrays.fill(recommendDirector, null);
        Arrays.fill(recommendGenre, null);
    }
}
