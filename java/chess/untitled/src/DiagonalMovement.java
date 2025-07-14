public class DiagonalMovement {
    public boolean validMove(String colour, Board board, int[] startPos, int[] endPos, int pieceRange) {
        if (Math.abs(endPos[0] - startPos[0]) != Math.abs(endPos[1] - startPos[1]))
            return false;

        int length = Math.abs(endPos[0] - startPos[0]);
        int columnChange = 1;
        int rowChange = 1;

        if (endPos[0] < startPos[0])
            rowChange = -1;

        if (endPos[1] < startPos[1])
            columnChange = -1;

        System.out.println("asdf");

        if (pieceRange >= length) {
            for (int r = 1; r < Math.abs(endPos[0] - startPos[0]); r++) {
                int[] tempPos = {startPos[0] + r * rowChange, startPos[1] + r * columnChange};
                if (board.pieceAt(tempPos) != null)
                    return false;
            }
            return true;
        }
        return false;
    }
}