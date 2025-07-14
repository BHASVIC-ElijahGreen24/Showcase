public class King extends Piece {
    private StraightMovement straight;
    private DiagonalMovement diagonal;

    King(String colour) {
        super(colour);
        this.type = "king";
        this.range = 1;
        this.straight = new StraightMovement();
        this.diagonal = new DiagonalMovement();
    }

    public boolean validMove(Board board, int[] startPos, int[] endPos) {
        if (!super.validMove(board, startPos, endPos))
            return false;

        if (this.straight.validMove(this.colour, board, startPos, endPos, this.range) || this.diagonal.validMove(this.colour, board, startPos, endPos, this.range))
            return true;

        return false;
    }
}