import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
/**
 * A class for the individual movies
 * 
 * @author Jarvis Warnock 
 * @version 4
 */
public class Movie
{
    // instance variables - replace the example below with your own
    private String movie;
    private String director;
    private String genre;
    private double rating;
    private int year;
    private boolean printed;
    private String ratingString;
    
    private static final int ORIGINALY = 105;
    private static final int STARTX = 105;
    private int startY = ORIGINALY;
    private static final int WIDTH = 385;
    private static final int HEIGHT = 50;
    private static final int OVALWIDTH = 50;
    private static final int OVALHEIGHT = 50;
    private static final int SIZE = 350;

    /**
     * Constructor for objects of class Movie
     * 
     * @param   movieName - the name of the movie
     * @param   movieDirector - the director of the movie
     * @param   movieGenre - the genre of the movie
     * @param   movieYear - the year the movie released
     */
    public Movie(String movieName, String movieDirector, 
                 String movieGenre, int movieYear)
    {
        // initialise instance variables
        this.movie = movieName;
        this.director = movieDirector;
        this.genre = movieGenre;
        // Sets to -1 to show it has no rating (added by the user later)
        this.rating = -1;
        this.year = movieYear;
    }

    /**
     * A method to get the name of the movie
     * 
     * @return     the name of the movie 
     */
    public String getName()
    {
        return this.movie;
    }
    
    /**
     * A method to get the director of the movie
     * 
     * @return      the director of the movie
     */
    public String getDirector()
    {
        return this.director;
    }
    
    /**
     * A method to get the genre of the movie
     * 
     * @return      the genre of the movie
     */
    public String getGenre()
    {
        return this.genre;
    }
    
    /**
     * A method to get the rating of the movie
     * 
     * @return      the rating of the movie
     */
    public double getRating()
    {
        return this.rating;
    }
    
    /**
     * A method to get the year of the movie
     * 
     * @return      the year of the movie
     */
    public int getYear()
    {
        return this.year;
    }
    
    /**
     * A method to change the rating of a movie
     * 
     * @param       newRating - the new rating for the movie
     */
    public void changeRating(double newRating)
    {
        this.rating = newRating;
        this.ratingString = String.valueOf(rating);        
    }
    
    /**
     * A method to change printed to true or false
     * 
     * @param      ifPrinted - the new value for printed
     */
    public void changePrinted(boolean ifPrinted)
    {
        this.printed = ifPrinted;
    }
    
    /**
     * A method to check the value of printed
     * 
     * @return     printed (if the movie has been printed or not)
     */
    public boolean getPrinted()
    {
        return this.printed;
    }
    
    /**
     * A method to draw the information when searched for
     * 
     * @param   searchNumber - the number down the list the movie is displayed
     */
    public void drawSearched(int searchNumber)
    {
        this.startY = this.ORIGINALY + ((searchNumber + 1) * 70);
        UI.setColor(Color.black);
        UI.fillRect(this.STARTX, this.startY, this.WIDTH, this.HEIGHT);
        UI.setColor(Color.white);
        UI.setFontSize(30);
        UI.drawString(this.movie + " (" + this.year + ")", 
                      this.STARTX + 15, this.startY + 25);
        UI.setFontSize(15);
        UI.drawString("Click for more info", 
                      this.STARTX + 15, this.startY + 45);
    }
    
    /**
     * A method to print the info when the search result is clicked
     */
    public void drawInfo()
    {
        startY = ORIGINALY + 75;
        UI.clearGraphics();
        GUI.drawMain();
        UI.drawImage("images/movie-placeholder.png", 
                     this.STARTX, this.startY - 100, SIZE, SIZE + 85);
        UI.setColor(Color.black);
        UI.setFontSize(30);
        UI.drawString(this.movie + " (" + year + ")", 
                      this.STARTX + 15, this.startY + 375);
        UI.drawString("Director: " + this.director, 
                      this.STARTX + 15, this.startY + 425);
        UI.drawString("Genre: " + this.genre, 
                      this.STARTX + 15, this.startY + 475);
        // Changes the colour around the rating depending on what it is
        if (rating != -1)
        {
            if (rating >= 7)
            {
                UI.setColor(Color.green);
            } 
            else if (rating > 3 && rating < 7)
            {
                UI.setColor(Color.orange);
            } 
            else 
            {
                UI.setColor(Color.red);
            }
            UI.fillOval(this.STARTX + 15, this.startY + 500, 
                        this.OVALWIDTH, this.OVALHEIGHT);
            UI.setColor(Color.white);
            UI.setFontSize(20);
            UI.drawString(this.ratingString, this.STARTX + 20, 
                          this.startY + 533);
        } 
        else 
        {
            UI.drawString("Movie not yet rated", this.STARTX + 15, 
                          this.startY + 525);
        }
    }
    
    /**
     * A method to check if the user clicked the search result
     * 
     * @param   x - the x position of the mouse
     * @param   y - the y position of the mouse
     * 
     * @return  boolean - if the click was on the movie
     */
    public boolean onSearched(double x, double y)
    {
        if (x >= this.STARTX && x <= this.STARTX + this.WIDTH &&
            y >= this.startY && y <= this.startY + this.HEIGHT)
        {
            return (true);
        } 
        else 
        {
            return (false);
        }
    }
    
    
}
