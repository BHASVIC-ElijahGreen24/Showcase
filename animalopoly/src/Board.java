public class Board {
    private Tile[] tiles;

    public Board(Animal[] animals) {
        this.tiles = new Tile[26];

        for(int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile("0".repeat(2-String.valueOf(i).length()) + String.valueOf(i) + "   ", animals[i]); // create the tiles array with all the animals and such
        }

        tiles[0] = new Tile("start", null); // fix these two special tiles w/out animals
        tiles[13] = new Tile("skip ", null);
    }

    public String[] createTile(int[] range, String join, Player[] players) {
        String[][] out = new String[3][range.length]; // this is an array of {{player displays}, {tile displays}, {animal displays}}
        String[] joined = new String[3]; // this is the array returned of {player displays, tile displays, animal displays}

        for(int i = 0; i < range.length; i++) { // for each tile we need to be drawing
            out[0][i] = "";
            for(int j = 0; j < players.length; j++) { // add player line
                out[0][i] += (players[j].getPosition() == range[i]) ? players[j].getSymbol() : " "; // if player on square draw player, else fill with a space
            }
            out[0][i] += " ".repeat(5 - players.length); // extra spaces for player display
            out[1][i] = this.tiles[range[i]].getDisplay(); // title of the tile, ie "01" or "start"
            out[2][i] = ((this.tiles[range[i]].getAnimal() == null) ? "  " : this.tiles[range[i]].getAnimal().getAnimalEmoji()) + "   "; // animal emoji of the tile
        }

        for(int i = 0; i < 3; i++) {
            joined[i] = String.join(join, out[i]);
        }

        return joined; // return the array
    }

    public String[] createTile(int start, int end, String join, Player[] players) {
        int[] range = new int[8];

        for(int i = 0; i < Math.abs(end-start); i++) { // basically range() in python yeaj
            range[i] = start > end ? start - i : i; // but also support that backwards thing
        }

        return createTile(range, join, players);
    }

    public void displayBoard(Player[] players) {
        String output = "-".repeat(65); // top of board
        output += "\n| " + String.join(" |\n| ", createTile(0, 8, " | ", players)); // top row of tiles 0-8
        output += " |\n" + "-".repeat(65) + "\n| "; // separating row

        String sep = " |\n" + "-".repeat(9) + " ".repeat(47) + "-".repeat(9) + "\n| ";

        String[] lines = new String[5];
        for(int i = 0; i < 5; i++) { // squares 8-12 and 21-25
            lines[i] = String.join(" |\n| ", createTile(new int[] {25 - i, 8 + i}, " | " + " ".repeat(45) + " | ", players));
        }
        output += String.join(sep, lines) + " |\n";
        output += "-".repeat(65); // separating row
        output += "\n| " + String.join(" |\n| ", createTile(20, 12, " | ", players)); // bottom row of tiles 12-20
        output += " |\n" + "-".repeat(65) + "\n\n"; // last separating row

        System.out.println(output);
    }

    public Tile getTile(int pos) { // accessor for this.tiles
        return this.tiles[pos];
    }
}
