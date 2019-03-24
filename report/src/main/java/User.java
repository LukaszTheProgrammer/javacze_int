import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class User {
    ;
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Movie>movies=new ArrayList<>();
    public User(long userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public List<Movie> addMovies(List<Movie> movies){
      return   this.movies=movies;


    }
    public int getMoviesCount(){
     return   movies.size();
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return firstName +lastName;
    }



    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
