public class Movie {

    private long id;
    private String title;
    private int length;
    private long authorId;

    public Movie(long id, String title, int length, long authorId) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", length=").append(length);
        sb.append(", authorId=").append(authorId);
        sb.append('}');
        return sb.toString();
    }
}
