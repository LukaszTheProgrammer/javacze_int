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

    public Movie() {

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

    public long getAuthorId() {
        return authorId;
    }

    public Movie id(long id) {
    this.id=id;
    return this;
    }

    public Movie title(String title) {
        this.title=title;
        return this;
    }

    public Movie length(int length) {
        this.length=length;
        return this;
    }

    public Movie authorId(long authorId) {
        this.authorId=authorId;
        return this;
    }
}
