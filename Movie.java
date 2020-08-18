
/**
 * A class for the individual movies
 * 
 * @author Jarvis Warnock 
 * @version 3
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

    /**
     * Constructor for objects of class Movie
     */
    public Movie(String movieName, String movieDirector, String movieGenre, int movieYear)
    {
        // initialise instance variables
        this.movie = movieName;
        this.director = movieDirector;
        this.genre = movieGenre;
        this.rating = -1;   // Sets to -1 to show it has no rating (added by the user later)
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
     * 
     * @return      void
     */
    public void changeRating(double rating){
        this.rating = rating;
    }
    
    /**
     * A method to change printed to true or false
     * 
     * @ param      printed - the new value for printed
     * 
     * @ return     void
     */
    public void changePrinted(boolean printed){
        this.printed = printed;
    }
    
    /**
     * A method to check the value of printed
     * 
     * @ param      none
     * 
     * @ return     printed (if the movie has been printed or not)
     */
    public boolean getPrinted(){
        return this.printed;
    }
}
