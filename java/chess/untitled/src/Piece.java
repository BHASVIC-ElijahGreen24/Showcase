public class Piece {
    protected String type;
    protected String colour;
    protected int range;
    private BasicMovement basic = new BasicMovement();

    public boolean validMove(Board board, int[] startPos, int[] endPos) {
        if (this.basic.validMove(this.colour, board, startPos, endPos))
            return true;
        else
            return false;
    }

    public void set_type(String nnew) {
        this.type = nnew;
    }

    Piece(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return this.type;
    }

    public String getColour() {
        return this.colour;
    }
}