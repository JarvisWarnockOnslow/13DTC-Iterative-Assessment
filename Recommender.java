import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * The class that contains all of the main methods for 
 * the program such as adding as movie
 * 
 * @author Jarvis Warnock
 * @version 4
 */
public class Recommender
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Movie> movieRecommendations;
    private boolean movieExists;
    private static final int RECOMMENDLENGTH = 8;
    private static final int MAXSEARCHRESULTS = 8;
    private String[] recommendDirector;
    private String[] recommendGenre;
    private String[] searchResults;
    private int i = 0;
    
    // Sets the position of the GUI elements
    private static final int STARTX = 150;
    private static final int STARTY = 125;
    

    /**
     * Constructor for objects of class Recommender
     */
    public Recommender()
    {
        // initialise instance variables
        movieRecommendations = new HashMap<Integer, Movie>();
        recommendDirector = new String[RECOMMENDLENGTH];
        recommendGenre = new String[RECOMMENDLENGTH];
        searchResults = new String[MAXSEARCHRESULTS];
        
    }

    /**
     * A method to add a movie to the hashmap
     * 
     * @param       movieName - the name of the movie
     * @param       movieDirector - the director of the movie
     * @param       movieGenre - the genre of the movie
     * @param       movieYear - the year the movie was released
     * @param       movieNumber - what number in the hashmap the movie is
     * 
     */
    public void addMovie(String movieName, String movieDirector, 
                         String movieGenre, int movieYear, Integer movieNumber)
    {
        // adds a movie to the hashmap with the 
        // variables provided form the GUI class
        movieRecommendations.put(movieNumber, new Movie(movieName, 
                                 movieDirector, movieGenre, movieYear));
        UI.println("Movie Added");
    }
    
    /**
     * A method to search for either a director or genre
     * 
     * @param      search - The title, director, or genre to search for
     */
    public void searchEither(String search)
    {
        int j = 0;
        // Clears the screen and redraws the title
        UI.clearGraphics();
        GUI.drawMain();
        UI.setColor(Color.black);
        UI.setFontSize(35);
        if (movieExists(search) == true)
        {
            // Draws the search results text
            UI.drawString("Search Results:", this.STARTX, this.STARTY);
            for (Integer key : movieRecommendations.keySet())
            {
                if (movieRecommendations.get(key).getDirector().equals(search) 
                    || movieRecommendations.get(key).getGenre().equals(search)
                    || movieRecommendations.get(key).getName().equals(search))
                {
                    UI.println("-------------------------------------");
                    UI.println("Title: " + 
                               movieRecommendations.get(key).getName() + 
                               " (" + movieRecommendations.get(key).getYear() + 
                               ")");
                    UI.println("Director: " + 
                               movieRecommendations.get(key).getDirector());
                    UI.println("Genre: " + 
                               movieRecommendations.get(key).getGenre());
                    if (movieRecommendations.get(key).getRating() != -1)
                    {
                        UI.println("Rating: " + 
                                   movieRecommendations.get(key).getRating());
                    }
                    searchResults[j] = movieRecommendations.get(key).getName()
                                       + " (" 
                                       + movieRecommendations.get(key).getYear()
                                       + ")";
                    movieRecommendations.get(key).drawSearched(j);
                    if (j <= 8)
                    {
                        j++;
                    }
                }
            }
        } 
        else 
        {
            UI.println("A movie with that " 
                      + "name/director/genre could not be found");
            UI.drawString("That search could not be found", 
                      this.STARTX - 90, this.STARTY);
        }
        // Clears the searchResult list
        Arrays.fill(searchResults, null);
    }
    
    /**
     * A method to print all of the movies in the hashmap
     */
    public void showAll()
    {
        for (Integer key : movieRecommendations.keySet())
        {
            UI.println("-------------------------------------");
            // Prints the title and year together
            UI.println("Title: " + movieRecommendations.get(key).getName() 
                       + " (" + movieRecommendations.get(key).getYear() + ")");
            UI.println("Director: " + 
                       movieRecommendations.get(key).getDirector());
            UI.println("Genre: " + movieRecommendations.get(key).getGenre());
            // Prints the rating only if the user has rated it
            if (movieRecommendations.get(key).getRating() != -1)
            {
                UI.println("Rating: " + 
                           movieRecommendations.get(key).getRating());
            }
            else
            {
                UI.println("Movie has not yet been rated");
            }
        }
    }
    
    /**
     * A method to rate/change the rating of a movie
     * 
     * @param       movieRate - the movie that is being rated
     * @param       rating - the new rating for the movie
     * 
     */
    public void rateMovie(String movieRate, double rating)
    {
        for (Integer key : movieRecommendations.keySet())
        {
            if (movieRecommendations.get(key).getName().equals(movieRate))
            {
                movieRecommendations.get(key).changeRating(rating);
                UI.println("Movie Rated");
            }
        }
    }
    
    /**
     * A method to check if a movie exists (for the search and rating methods)
     * 
     * @param      movieSearch - the name of the movie to check for
     * 
     * @return     boolean - if the movie exists or not
     */
    public boolean movieExists(String movieSearch)
    {
        movieExists = false;
        for (Integer key : movieRecommendations.keySet())
        {
            if (movieRecommendations.get(key).getDirector().equals(movieSearch)
                || movieRecommendations.get(key).getGenre().equals(movieSearch)
                || movieRecommendations.get(key).getName().equals(movieSearch))
            {
                movieExists = true;
            }
        }
        return (movieExists);
    }
    
    /**
     * A method to recommend movies based on previous ratings
     * Recommends movies that have not been rated by the same 
     * director or in the same genre as ones you have rated highly 
     * 
     * @ param       none
     * 
     * @ return      void
     */
    public void recommendMovie()
    {
        // Adds the directors and genres of highly rated movies to an array
        int printed = 0;
        i = 0;
        UI.clearGraphics();
        GUI.drawMain();
        for (Integer key : movieRecommendations.keySet())
        {
            if (movieRecommendations.get(key).getRating() > 6)
            {     // Checks if the movies rating is greater than 6
                if (!Arrays.asList(recommendDirector).contains(
                    movieRecommendations.get(key).getDirector()))
                {       // Learnt on w3 schools
                    recommendDirector[i] = movieRecommendations.get(key)
                                           .getDirector();
                }
                if (!Arrays.asList(recommendGenre).contains(
                    movieRecommendations.get(key).getGenre()))
                {       // Learnt on w3 schools
                    recommendGenre[i] = movieRecommendations.get(key)
                                        .getGenre();
                }
                // Stops after 8 else there may be too many movies recommended
                if (i <= 7)
                {
                    i++;
                }
            }
        }
        // Draws the movies you may like text on the GUI
        UI.setColor(Color.black);
        UI.setFontSize(35);
        UI.drawString("Movies You May Like:", this.STARTX, this.STARTY);
        // Prints out all of the movies in the list
        for (String director : recommendDirector)
        {
            for (Integer key : movieRecommendations.keySet())
            {
                if (movieRecommendations.get(key).getDirector().equals(director)
                    && movieRecommendations.get(key).getRating() == -1
                    && printed <= 7)
                {
                    movieRecommendations.get(key).drawSearched(printed);
                    // Makes sure the same movie is not in both lists
                    movieRecommendations.get(key).changePrinted(true);
                    printed++;
                }
            }
        }
        for (String genre : recommendGenre)
        {
            for (Integer key : movieRecommendations.keySet())
            {
                if (movieRecommendations.get(key).getGenre().equals(genre) && 
                    movieRecommendations.get(key).getRating() == -1 && 
                    movieRecommendations.get(key).getPrinted() == false
                    && printed <= 7)
                {
                    movieRecommendations.get(key).drawSearched(printed);
                    movieRecommendations.get(key).changePrinted(false);
                    printed++;
                }
            }
        }
        
        // If no movies are printed then thell the user to add more
        if (printed == 0)
        {
            UI.println("There are no movies to recommend (Try add some more)");
        }
        // Empties the arrays after the recommended movies have been printed
        Arrays.fill(recommendDirector, null);
        Arrays.fill(recommendGenre, null);
    }
    
    /**
     * A method to manage if the mouse has been clicked
     * 
     * @param   action - the action of the mouse
     * @param   x - the x position of the mouse
     * @param   y - the y position of the mouse
     */
    public void manageMouse(String action, double x, double y)
    {
        if (action.equals("clicked"))
        {
            for (Integer key : movieRecommendations.keySet())
            {
                if (movieRecommendations.get(key).onSearched(x , y) == true)
                {
                    movieRecommendations.get(key).drawInfo();
                }
            }
        }
    }
}
