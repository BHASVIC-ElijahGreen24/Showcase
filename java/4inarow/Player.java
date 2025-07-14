public class Player {
    private String name;
    private int number;
    private int c;

    public Player(String n, int num) {
        this.name = n;
        this.number = num;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public void makeMove(Board board) {
        this.c = -1;
        while((this.c < 0 || this.c > board.getWidth() - 1) || board.columnFull(c)) {
            System.out.println("choose a column to drop a piece in: ");
            this.c = Integer.parseInt(Console.readLine()) - 1;
        }
        board.addToken(this.c, this.number);
    }

    public String checkWinner(Board board) {
        return (board.checkWinner() == this.number ? this.name : "Nobody");
    }
}