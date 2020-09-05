import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * A class for the GUI of the program
 * 
 * @author Jarvis Warnock 
 * @version 4
 */
public class GUI
{
    private Recommender r = new Recommender();
    /**
     * The integer of what movie number it is in the hashmap
     */
    public Integer movieNumber = 1;
    private boolean again = true;
    private int movieYear;
    private String movieRate;
    private String movieName;
    private String movieDirector;
    private String movieGenre;
    private static final int CANVASWIDTH = 1000;
    private static final int CANVASHEIGHT = 750;
    /**
     * Constructor for the GUI class
     */
    public GUI()
    {
        // //Initializes the variables and UI aspects
        // UI.initialise();
        // UI.addTextField("Search Title/Director/Genre", this::searchEither);
        // UI.addButton("Add Movie", this::newMovie);
        // UI.addButton("Rate Movie", this::rateMovie);
        // UI.addButton("Show All Movies", this::printAll);
        // UI.addButton("Recommend Movies", this::recommendMovie);
        // UI.setMouseListener(r::manageMouse);
        // UI.addButton("Quit", UI::quit);
        // // Sets the size of the whole window and the divider
        // UI.setWindowSize(CANVASWIDTH, CANVASHEIGHT);
        // UI.setDivider(0.4);
        // this.drawMain();
    }
    
    /**
     * A method to draw the main aspects of the GUI
     */
    public static void drawMain()
    {
        // Draws the title of the program
        UI.setColor(Color.black);
        UI.fillRect(55, 5, 485, 50);
        UI.setColor(Color.white);
        UI.setFontSize(50);
        UI.drawString("Movie Recommender", 60, 50);
    }
    
    /**
     * A method to create a new movie
     */
    public void newMovie()
    {
        // Checks if the input is null
        while (again) {
            movieName = UI.askString("Movie title: ");
            if (movieName.length() == 0)
            {
                UI.println("Please enter a movie name");
            } 
            else
            {
                // Converts the title to lower case (Learnt on w3 Schools)
                movieName = movieName.toLowerCase();
                this.movieName = movieName;
                again = false;
            }
        }
        again = true;
        // Checks if the year is valid
        while (again) 
        {
            movieYear = UI.askInt("Release Year: ");
            try
            {
                if (movieYear < 1880 || movieYear > 2030) 
                {
                    throw new ArithmeticException();
                } 
                else if (movieYear == 0)
                {
                    throw new ArithmeticException();
                } 
                else 
                {
                    this.movieYear = movieYear;
                    again = false;
                }
            }
            
            catch (ArithmeticException ae) 
            {
                UI.println("Please enter a year 1880-2030");
            }
            
            catch (Exception e) 
            {
                UI.println("Please enter a year 1880-2030");
            }
        }
        again = true;
        // Checks if the input is null
        while (again)
        {
            movieDirector = UI.askString("Director: ");
            if (movieDirector.length() == 0)
            {
                UI.println("Please enter a director");
            } 
            else
            {
                // Converts the director to lower case (Learnt on w3 Schools)
                movieDirector = movieDirector.toLowerCase();
                this.movieDirector = movieDirector;
                again = false;
            }
        }
        again = true;
        // Checks if the input is null
        while (again)
        {
            movieGenre = UI.askString("Genre: ");
            if (movieGenre.length() == 0)
            {
                UI.println("Please enter a genre");
            } 
            else
            {
                // Converts the genre to lower case (Learnt on w3 Schools)
                movieGenre = movieGenre.toLowerCase();
                this.movieGenre = movieGenre;
                again = false;
            }
        }
        again = true;
        // Sends the details to the addMovie class to be added to hashmap
        r.addMovie(movieName, movieDirector, 
                   movieGenre, movieYear, movieNumber);
        this.movieNumber++;
    }
    
    /**
     * Calls the method to show all the movies
     */
    public void printAll()
    {
        r.showAll();
    }
    
    /**
     * Calls the method to search for either the 
     * movies by a director or in a genre
     * 
     * @param   search - the inputted search from the textfield
     */
    public void searchEither(String search)
    {
        //String search = UI.askString("Director or Genre: ");
        search = search.toLowerCase();
        r.searchEither(search);
    }
    
    /**
     * Calls the method to rate a movie
     */
    public void rateMovie()
    {
        // Loop to check if the entered movie exists
        movieRate = UI.askString("Movie Title: ");
        movieRate = movieRate.toLowerCase();
        while (again) 
        {
            // Checks if the movie exists
            if (r.movieExists(movieRate) == false)
            {
                UI.println("That movie does not exist");
                movieRate = UI.askString("Movie Title: ");
            } 
            else 
            {
                again = false;
            }
        }
        again = true;
        // Loop to check if the rating is 0-10
        while (again) 
        {
            double rating = UI.askDouble("Rating: ");
            try
            {
                if (rating < 0 || rating > 10) 
                {
                    throw new ArithmeticException();
                } 
                else 
                {
                    r.rateMovie(movieRate, rating);
                    again = false;
                }
            }
            
            catch (ArithmeticException ae) 
            {
                UI.println("Please enter a number 0-10");
            }
            
            catch (Exception e) 
            {
                UI.println("Please enter a number 0-10");
            }
        }
        again = true;
    }
    
    /**
     * Calls the method to recommend movies
     */
    public void recommendMovie()
    {
        r.recommendMovie();
    }

    /**
     * The main method for the program to start everything
     * 
     * @param args - command supplied arguments
     */
    public static void main(String[] args)
    {
        GUI obj = new GUI();
    }

}

