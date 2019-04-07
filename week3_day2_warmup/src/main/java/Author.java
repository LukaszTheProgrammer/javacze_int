import java.util.ArrayList;
import java.util.List;

public class Author {

    private final long id;
    private final String fullname;
    private final String email;
    private final long teamId;
    private List<Picture> pictures = new ArrayList<>();

    public Author(long id, String fullname, String email, long teamId) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public void addPictures(List<Picture> pictures) {
        this.pictures.addAll(pictures);
    }

    public Integer getPicturesCount() {
        return pictures.size();
    }

    public String getFullname() {
        return fullname;
    }

    public Long getTeamId() {
        return teamId;
    }
}
