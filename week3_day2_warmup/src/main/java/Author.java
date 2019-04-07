public class Author {

    private final long id;
    private final String fullname;
    private final String email;
    private final long teamId;

    public Author(long id, String fullname, String email, long teamId) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.teamId = teamId;
    }
}
