import java.util.List;

public class User {

    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Movie> movies;

    public User() {
    }

    public User(long userId, String firstName, String lastName, String email, List<Movie> userMovies) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        movies = userMovies;
    }

    public long getId() {
        return userId;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getMoviesCount() {
        return movies.size();
    }


    public User id(long id) {
        this.userId = id;
        return this;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User movies(List<Movie> userMovies) {
        this.movies = userMovies;
        return this;
    }
}
