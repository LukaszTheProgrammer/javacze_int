public class Board {

    private final static int rowOffset = 2;
    private final static int columnOffset = 2;
    private char[][] boardContent;

    public Board(int rowCount, int columnCount) {
        this.boardContent = new char[rowCount + rowOffset][];
        for (int i = 0; i < rowCount + rowOffset; i++) {
            this.boardContent[i] = new char[columnCount + columnOffset];
        }

        for (int i = 0; i < boardContent.length - 2; i++) {
            this.boardContent[boardContent.length - 1][i + 2] = String.valueOf(i).charAt(0);
        }
        for (int i = boardContent.length - 3; i >= 0; i--) {
            this.boardContent[i][0] = String.valueOf(rowCount - i - 1).charAt(0);
        }
        for (int i = 1; i < boardContent.length; i++) {
            this.boardContent[boardContent.length - 2][i] = '_';
        }
        for (int i = boardContent.length - 3; i >= 0; i--) {
            this.boardContent[i][1] = '|';
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < boardContent.length; i++) {
            for (int j = 0; j < boardContent[i].length; j++) {
                result += boardContent[i][j];
            }
            result += "\n";
        }
        return result;
    }

    public char getCell(int rowIndex, int columnIndex) {
        return boardContent[rowIndex][columnIndex];
    }

    public void insertPoint(int x, int y) {
        boardContent[boardContent.length - y - 3][x+2] = 'x';
    }
}
