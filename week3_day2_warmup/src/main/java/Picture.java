public class Picture {

    private final long id;
    private final String imgFile;
    private final long authorId;

    public Picture(long id, String imgFile, long authorId) {
        this.id = id;
        this.imgFile = imgFile;
        this.authorId = authorId;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
