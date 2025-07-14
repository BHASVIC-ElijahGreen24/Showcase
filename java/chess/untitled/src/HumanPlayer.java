class HumanPlayer extends Player {

	public boolean movePiece(Board board) {
        boolean end = false;
        int[] startPos = null;
        String startDisplay = "";
        
        while (end != true) {
            boolean posSet = false;
            while (!posSet) {
                board.display();
                System.out.println();
                System.out.println(this.colour + "'s turn:");
                System.out.println("Enter the location of the piece you would like to move (e.g. A1):");
                startDisplay = Console.readLine();
                System.out.println();
                startPos = this.getPos(board, this.colour, startDisplay);
                if (startPos != null && board.pieceAt(startPos) != null && board.pieceAt(startPos).getColour() == this.colour)
                    posSet = true;
                else {
                    System.out.println("You don't have a piece at " + startDisplay + " to move! Please try again.");
                    System.out.println();
                }
            }
            board.display();
            System.out.println();
            System.out.println(this.colour + "'s turn:");
            System.out.println("Where would you like to move the " + board.pieceAt(startPos).getType() + " from " + 
			startDisplay.toUpperCase() + " to?:");
            String endPos = Console.readLine();
            System.out.println();
            end = this.getPos(board, this.colour, startPos, endPos);
        }
        System.out.println();
        System.out.println();
        return board.gameOver();
    }
        
    private int[] getPos(Board board, String colour, String startPos) {
       int[] checkPos = {-1, -1};
        if (startPos.length() > 2)
            return null;
        try {
            int startRow = board.getHeight() + 64 - (int)(startPos.toUpperCase().charAt(0));
            int startColumn = Integer.parseInt(startPos.substring(1)) - 1;
            if (startRow < 0 || startRow >= board.getHeight() || startColumn < 0 || startColumn >= board.getHeight())
            	return null;
            else {
            	checkPos[1] = startRow;
            	checkPos[0] = startColumn;
            }
        }
        catch (Exception e) {
            return null;
        }
        if (board.pieceAt(checkPos) == null)
            return null;
        else
            return checkPos;
    }
    
	private boolean getPos(Board board, String colour, int[] startPos, String endPos) {
		int[] checkPos = {-1, -1};        
        if (endPos.length() > 2)
        	return false;
            	            
        try {
        	int endRow = board.getHeight() + 64 - (int)(endPos.toUpperCase().charAt(0));
            int endColumn = Integer.parseInt(endPos.substring(1)) - 1;
            if (endRow < 0 || endRow >= board.getHeight() || endColumn < 0 || endColumn >= board.getHeight())
            	return false;
            else {
            	checkPos[1] = endRow;
            	checkPos[0] = endColumn;
            }
        }
        catch (Exception e) {
        	return false;
        }  
        return board.movePiece(colour, startPos, checkPos);
    }

    HumanPlayer(String colour) {
        this.colour = colour;
    }
}