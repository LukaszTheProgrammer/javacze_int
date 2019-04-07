import java.util.Arrays;
import java.util.List;

public class WarmupRunner {
    private final static List<Team> teams = Arrays.asList(
        new Team(1L, "Tigers"), new Team(2L, "Panthers"),
        new Team(3L, "Lions"), new Team(4L, "Bobcats")
    );

    private final static List<Author> authors = Arrays.asList(
        new Author(1L, "Jim Beam", "jim@tigers.com", 1L),
        new Author(2L, "Johny Walker", "johny@bobcats.com", 4L),
        new Author(3L, "Bob Doe", "bob@bobcats.com", 4L),
        new Author(4L, "Sue Brown", "sue@panthers.com", 2L),
        new Author(5L, "Larry Bing", "larry@tigers.com", 1L),
        new Author(6L, "Michael Bay", "michael@lions.com", 3L),
        new Author(7L, "Suzzy Pink", "suzzy@lions.com", 3L),
        new Author(8L, "Alice Smith", "alice@lions.com", 3L),
        new Author(9L, "Dan Lee", "dan@tigers.com", 1L)
    );

    private final static List<Picture> pictures = Arrays.asList(
      new Picture(1L, "123.jpg", 1L),new Picture(2L, "124.jpg", 2L),
      new Picture(3L, "125.jpg", 4L),new Picture(4L, "126.jpg", 3L),
      new Picture(5L, "127.jpg", 1L),new Picture(6L, "128.jpg", 2L),
      new Picture(7L, "129.jpg", 5L),new Picture(8L, "130.jpg", 4L),
      new Picture(9L, "131.jpg", 5L),new Picture(10L, "132.jpg", 2L),
      new Picture(11L, "133.jpg", 6L),new Picture(12L, "134.jpg", 1L),
      new Picture(13L, "135.jpg", 7L),new Picture(14L, "136.jpg", 2L),
      new Picture(15L, "137.jpg", 8L),new Picture(16L, "138.jpg", 9L),
      new Picture(17L, "139.jpg", 3L),new Picture(18L, "140.jpg", 9L),
      new Picture(19L, "141.jpg", 4L),new Picture(20L, "142.jpg", 2L),
      new Picture(21L, "143.jpg", 2L),new Picture(22L, "144.jpg", 4L),
      new Picture(23L, "145.jpg", 8L),new Picture(24L, "146.jpg", 4L),
      new Picture(25L, "147.jpg", 2L),new Picture(26L, "148.jpg", 4L)
    );

    public static void main(String[] args) {

    }
}
