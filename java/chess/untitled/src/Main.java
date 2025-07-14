public class Main {
	
	public Main() {
		Board board = new Board();
		HumanPlayer white = new HumanPlayer("White");
		HumanPlayer black = new HumanPlayer("Black");
    
		while (!board.gameOver()) {
			System.out.println();
			System.out.println("It's White's turn to move:");
			white.movePiece(board);
			if (board.gameOver())
				break;
			System.out.println();
			System.out.println("It's Black's turn to move:");
			black.movePiece(board);
		}
		board.display();
		Console.readLine();
    }
    
    public static void main(String[] args) {
        new Main();
    }
}