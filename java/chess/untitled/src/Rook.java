public class Rook extends Piece {
    private StraightMovement straight;

    Rook(String colour) {
        super(colour);
        this.type = "rook";
        this.range = 9;
        this.straight = new StraightMovement();
    }

    public boolean validMove(Board board, int[] startPos, int[] endPos) {
        if (!super.validMove(board, startPos, endPos))
            return false;

        if (this.straight.validMove(this.colour, board, startPos, endPos, this.range))
            return true;

        return false;
    }
}