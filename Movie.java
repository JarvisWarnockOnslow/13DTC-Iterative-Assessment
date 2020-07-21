
/**
 * A class for the individual movies
 * 
 * @author Jarvis Warnock 
 * @version 1
 */
public class Movie
{
    // instance variables - replace the example below with your own
    private String movie;
    private String director;
    private String genre;
    private double rating;

    /**
     * Constructor for objects of class Movie
     */
    public Movie(String movieName, String movieDirector, String movieGenre, double movieRating)
    {
        // initialise instance variables
        this.movie = movieName;
        this.director = movieDirector;
        this.genre = movieGenre;
        this.rating = movieRating;
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
    
    public void changeRating(double newRating){
        this.rating = newRating;
    }
}
