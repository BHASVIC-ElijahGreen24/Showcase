import java.util.Objects;

public class Board {
    private int columns = 8;
    private int rows = 8;
    private Piece[][] board = new Piece[8][8];
    private boolean game_over = false;

    Board() { // set up the board with the actual starting positions
        for(int i = 0; i < this.columns; i++) {
            board[6][i] = new Pawn("Black");
            board[1][i] = new Pawn("White");
        }
        board[0][0] = new Rook("White");
        board[0][7] = new Rook("White");
        board[7][0] = new Rook("Black");
        board[7][7] = new Rook("Black");

        board[0][1] = new Knight("White");
        board[0][6] = new Knight("White");
        board[7][1] = new Knight("Black");
        board[7][6] = new Knight("Black");

        board[0][2] = new Bishop("White");
        board[0][5] = new Bishop("White");
        board[7][2] = new Bishop("Black");
        board[7][5] = new Bishop("Black");

        board[0][3] = new King("White");
        board[7][3] = new King("Black");

        board[0][4] = new Queen("White");
        board[7][4] = new Queen("Black");
    }

    public void display() {
    	String y = "";
    	String z = "";
        String firstLine = "   ";
        String breakLine = "";
        for (int i = 0; i < (5*this.columns)+4; i ++)
			breakLine += "-";
        		
        for (int c=0; c < this.columns; c++)
            firstLine += ("| " + (char)(this.columns + 64 - c) + "  ");

        firstLine += "|";
        System.out.println(firstLine);
        		
        System.out.println(breakLine);
        for (int r=0; r < this.rows; r++) {
            System.out.print(" " + (r+1) + " ");
            for (int c=0; c < this.columns; c++) {
                if (this.board[r][c] == null) {
                    y = " ";
                    z = "   ";
                }
                else {
                    if(this.board[r][c].getType() == "knight") { // knights are represented by N not K in chess..
                        y = "n";
                    } else {

                        y = String.valueOf(this.board[r][c].getType().charAt(0));
                    }
                    z = "(" + this.board[r][c].getColour().toLowerCase().charAt(0)  + ")";
                }
                System.out.print("|" + y + z);
            }
            System.out.println("|");
            System.out.println(breakLine);
        }
        System.out.println();
    }
 
    public boolean movePiece(String colour,int[] startPos,int[] endPos) {
        Piece startPiece = this.board[startPos[0]][startPos[1]];
        Piece endPiece = this.board[endPos[0]][endPos[1]];
        if (startPiece != null) {
            if (startPiece.getColour().equals(colour)) {
                if (startPiece.validMove(this, startPos, endPos)) {
                    System.out.println(colour + "'s " + startPiece.getType() + " was moved to " + 
					(char)(endPos[0]+65) + (endPos[1]+1) + ".");
                    this.takePiece(startPiece, endPiece);
                    this.board[startPos[0]][startPos[1]] = null;
                    this.board[endPos[0]][endPos[1]] = startPiece;
                    this.upgradePiece(startPiece, endPos);
                    System.out.println();
                    return true;
                }
            }
    	}
        System.out.println("That is not a valid move! Please try again.");
        return false;
    }

    public void upgradePiece(Piece p, int[] pos) {
        if((pos[0] == 7 || pos[0] == 0) && Objects.equals(p.getType(), "pawn")) {
            board[pos[0]][pos[1]] = new Queen(p.getColour());
        }
    }

    public void takePiece(Piece st, Piece end) {
        if(end != null) {
            if(end.getType() == "king") {
                this.game_over = true;
            }
            System.out.println("wow that " + st.getType() + " just captured that " + end.getType());
        }
    }

    public Piece pieceAt(int[] pos) {
        return this.board[pos[0]][pos[1]];
    }

    public int getWidth() {
        return columns;
    }

    public int getHeight() {
        return rows;
    }

    public boolean gameOver() {
        return game_over;
    }
}