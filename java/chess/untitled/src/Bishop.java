public class Bishop extends Piece {
    private DiagonalMovement diagonal;

    Bishop(String colour) {
        super(colour);
        this.type = "bishop";
        this.range = 9;
        this.diagonal = new DiagonalMovement();
    }

    public boolean validMove(Board board, int[] startPos, int[] endPos) {
        if (!super.validMove(board, startPos, endPos))
            return false;

        if (this.diagonal.validMove(this.colour, board, startPos, endPos, this.range)) {
            return true;
        }

        return false;
    }
}