
public class PointTask {

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(7, 4);

        Board b = new Board(7, 7);
        b.insertPoint(1,1);
        b.insertPoint(2,2);
        b.insertPoint(1,4);
        System.out.println(b);
    }
}
