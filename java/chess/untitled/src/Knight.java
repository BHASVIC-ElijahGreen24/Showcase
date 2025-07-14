import java.util.Arrays;

public class Knight extends Piece {
    Knight(String colour) {
        super(colour);
        this.type = "knight";
        this.range = 2;
    }

    public boolean validMove(Board board, int[] startPos, int[] endPos) {
        if (!super.validMove(board, startPos, endPos))
            return false;

        return (Math.abs(startPos[0] - endPos[0]) == 2 && Math.abs(startPos[1] - endPos[1]) == 1) || (Math.abs(startPos[0] - endPos[0]) == 1 && Math.abs(startPos[1] - endPos[1]) == 2);
    }
}
/*
 0 1 2 3 4 5 6
0
1  k   k
2k       k
3    k
4k       k
5  k   k
6
*/
