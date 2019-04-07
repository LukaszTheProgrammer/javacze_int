import java.util.ArrayList;
import java.util.List;

public class Team {

    private final long id;
    private final String name;
    private final List<Author> authors = new ArrayList<>();

    public Team(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAuthors(List<Author> authors) {
        this.authors.addAll(authors);
    }

    public Integer getPictureCount() {
        return authors.stream()
            .map(Author::getPicturesCount)
            .reduce(0, (acc, elem) -> acc + elem);
    }
}
