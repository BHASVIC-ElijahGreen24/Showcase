public class BasicMovement {
    public boolean validMove(String colour, Board board, int[] startPos, int[] endPos) {
        if (endPos[0] >= 0 && endPos[0] < board.getHeight()) {
            if (endPos[1] >= 0 && endPos[1] < board.getWidth()) {
                if (startPos != endPos) {
                    if (board.pieceAt(endPos) != null) {
                        if (!board.pieceAt(endPos).getColour().equals(colour))
                            return true;
                    }
                    else
                        return true;
                }
            }
        }
        return false;
    }
}