public class Board {
    private int rows;
    private int columns;
    private int[][] board;

    public void addToken(int col, int token) {
        for(int i = this.rows - 1; i >= 0; i--) {
            if(board[i][col] == -1) {
                board[i][col] = token;
                return;
            }
        }
        System.out.println("failed to place token " + token);
    }

    public boolean columnFull(int col) {
        if(board[0][col] != -1) {
            return true;
        }
        return false;
    }

	public void display() {
        for (int i = 0; i < this.rows; i++) {
            for (int x = 0; x < this.columns; x++)
                System.out.print("|" + (this.board[i][x] == -1 ? " " : this.board[i][x]));
            System.out.println("|");
        }
        System.out.println();
	}

    public int checkWinner() {
        return checkVertical() != 0 ? checkVertical() : (checkHorizontal() != 0 ? checkHorizontal(): (checkRightDiagonal() != 0 ? checkRightDiagonal() : (checkLeftDiagonal() != 0 ? checkLeftDiagonal() : 0)));
    }

    private int checkVertical() {
        for (int c = 0; c < this.columns; c++) 
            for (int r = 0; r < this.rows - 3; r++) 
                if (this.board[r][c] != -1 && this.board[r][c] == this.board[r+1][c] && this.board[r+1][c] ==
				this.board[r+2][c] && this.board[r+2][c] == this.board[r+3][c])
                    return this.board[r][c];
        return 0;
    }
    
    private int checkHorizontal() {
    	for (int r = 0; r < this.rows; r++) 
            for (int c = 0; c < this.columns - 3; c++)
                if (this.board[r][c] != -1 && this.board[r][c] == this.board[r][c+1] && this.board[r][c+1] ==
				this.board[r][c+2] && this.board[r][c+2] == this.board[r][c+3])
                    return this.board[r][c];
        return 0;
    }
    
    private int checkRightDiagonal() {
        for (int r = 0; r < this.rows - 3; r++) 
        	for (int c = 0; c < this.columns - 3; c++)
                if (this.board[r][c] != -1 && this.board[r][c] == this.board[r+1][c+1] && this.board[r+1][c+1] ==
				this.board[r+2][c+2] && this.board[r+2][c+2] == this.board[r+3][c+3])
                    return this.board[r][c];
        return 0;
    }
    
    private int checkLeftDiagonal() {
        for (int r = 0; r < this.rows - 3; r++) 
        	for (int c = 0; c < this.columns - 3; c++)
                if (this.board[r][(this.columns - 1) - c] != -1 && this.board[r][(this.columns - 1) - c] ==
				this.board[r+1][(this.columns - 2) - c] && this.board[r+1][(this.columns - 2) - c] == 
				this.board[r+2][(this.columns - 3) - c] && this.board[r+2][(this.columns - 3) - c] == 
				this.board[r+3][(this.columns - 4) - c])
                    return this.board[r][(this.columns - 1) - c];
        return 0;
    }

    public boolean boardFull() {
        for(int i = 0; i < this.columns; i++) {
            if(board[0][i] == -1) {
                return false;
            }
        }
        return true;
    }

    public Board(int width, int height) {
        this.columns = width;
        this.rows = height;
        this.board = new int[height][width];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                this.board[j][i] = -1;
            }
        }
    }

    public int getWidth() {
        return this.columns;
    }
}