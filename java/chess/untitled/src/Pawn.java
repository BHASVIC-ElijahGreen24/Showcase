public class Pawn extends Piece {
	private StraightMovement straight;
	private DiagonalMovement diagonal;
	
	Pawn(String colour) {
        super(colour);
        this.type = "pawn";
        this.range = 1;
        this.straight = new StraightMovement();
        this.diagonal = new DiagonalMovement();
	}
	
    public boolean validMove(Board board, int[] startPos, int[] endPos) {
        if (!super.validMove(board, startPos, endPos))
            return false;   
        if (this.colour.equals("White") && startPos[0] > endPos[0])
            return false;
        else if (this.colour.equals("Black") && startPos[0] < endPos[0])
            return false;

        if (startPos[1] == endPos[1]) {
            if (board.pieceAt(endPos) != null)
                return false;
            else {
                if (this.colour.equals("White") && startPos[0] == 1 || this.colour.equals("Black") &&
				startPos[0] == board.getHeight() - 2) {
                    if (this.straight.validMove(this.colour, board, startPos, endPos, this.range + 1))
                        return true;
                }
                else if (this.straight.validMove(this.colour, board, startPos, endPos, this.range))
                    return true;
			}
        }

        if (startPos[1] != endPos[1]) {
            if (board.pieceAt(endPos) == null)
                return false;
            else {
                if (this.diagonal.validMove(this.colour, board, startPos, endPos, this.range))
                    return true;
            }
        }    
        return false;
    }
}