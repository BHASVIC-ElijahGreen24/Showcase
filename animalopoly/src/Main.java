
import java.io.Console;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("Welcome to Animalopy!\n\nFor accessibility on different systems:\nPlease compile & run our game from the command line(rather than the intellij output window) for the emojis to align correctly.\nADDITIONALLY if you're using a weird version of cmd on windows, run the following command beforehand:\nchcp 65001\nto fix the encoding in order to display emojis (if they're appearing as question marks).\nif you compile it from linux it should work by default assuming you're using a font capable of emojis");
        //Game starting options
        boolean playersValid = false, piecesValid = false;
        boolean piecePicked[] = {false, false, false, false}, gameOver = false, pChoiceValid = false, buyValid=false, manageValid=false;
        int players = 0, currentPlayer = 0, devChoice, playerChoice, playersOut = 0, animalX, aManage;
        char buyInput, manageOption;
        String pPiece = "";
        Animal[] animals = {
                null,
                new Animal("Ladybird", "\uD83D\uDC1E", null, 150),
                new Animal("Ant", "\uD83D\uDC1C", null, 200),
                new Animal("Bee", "\uD83D\uDC1F", null, 250),
                new Animal("Mouse", "\uD83D\uDC01", null, 300),
                new Animal("Hedgehog", "\uD83E\uDD94", null, 350),
                new Animal("Badger", "\uD83E\uDDA1", null, 400),
                new Animal("Chicken", "\uD83D\uDC14", null, 500),
                new Animal("Penguin", "\uD83D\uDC27", null, 550),
                new Animal("Eagle", "\uD83E\uDD85", null, 600),
                new Animal("Sheep", "\uD83D\uDC11", null, 700),
                new Animal("Pig", "\uD83D\uDC16", null, 750),
                new Animal("Cow", "\uD83D\uDC04", null, 800),
                null,
                new Animal("Lizard", "\uD83E\uDD8E", null, 900),
                new Animal("Turtle", "\uD83D\uDC22", null, 950),
                new Animal("Snake", "\uD83D\uDC0D", null, 1000),
                new Animal("Goat", "\uD83D\uDC10", null, 1100),
                new Animal("Horse", "\uD83D\uDC34", null, 1150),
                new Animal("Camel", "\uD83D\uDC2A", null, 1200),
                new Animal("Hippo", "\uD83E\uDD9B", null, 1300),
                new Animal("Giraffe", "\uD83E\uDD92", null, 1400),
                new Animal("Elephant", "\uD83D\uDC18", null, 1500),
                new Animal("Dolphin", "\uD83D\uDC2C", null, 1600),
                new Animal("Shark", "\uD83E\uDD88", null, 1800),
                new Animal("Whale", "\uD83D\uDC0B", null, 2000)
        };
        int dTotal;
        Dice dice = new Dice();
        while (playersValid == false) {
            players = Integer.parseInt(console.readLine("How many players for this game?"));
            if (players < 2) {
                System.out.println("That is too little players try again");
                playersValid = false;
            }
            else if (players > 4) {
                System.out.println("That is too many players try again");
                playersValid = false;
            }
            else if (players > 1 || players < 5) {
                playersValid = true;
            }
            else {
                System.out.println("That is an invalid input");
            }
        }
        Player[] playersArray = new Player[players];
        //Player starting options
        for (int i = 1; i <= players; i++) {
            System.out.println("Player " + i + "\t Enter your name:");
            String pName = console.readLine();
            piecesValid = false;
            while (piecesValid == false) {
                System.out.println("What piece do you want to play?:\ta)@\tb)!\tc)$\td)#;");
                char pieceInput = console.readLine().charAt(0);
                if (pieceInput == 'a') {
                    if (piecePicked[0] == true) {
                        System.out.println("Sorry this has already been picked");
                    } else {
                        pPiece = "@";
                        piecePicked[0] = true;
                        piecesValid = true;
                    }
                } else if (pieceInput == 'b') {
                    if (piecePicked[1] == true) {
                        System.out.println("Sorry this has already been picked");
                    } else {
                        pPiece = "!";
                        piecePicked[1] = true;
                        piecesValid = true;
                    }
                } else if (pieceInput == 'c') {
                    if (piecePicked[2] == true) {
                        System.out.println("Sorry this has already been picked");
                    } else {
                        pPiece = "$";
                        piecePicked[2] = true;
                        piecesValid = true;
                    }
                } else if (pieceInput == 'd') {
                    if (piecePicked[3] == true) {
                        System.out.println("Sorry this has already been picked");
                    } else {
                        pPiece = "#";
                        piecePicked[3] = true;
                        piecesValid = true;
                    }
                } else {
                    System.out.println("That is not a valid piece");
                }

            }
            playersArray[i - 1] = new Player(pName, i, pPiece);
        }
//        System.out.println("Pick player");
//        devChoice = Integer.parseInt(console.readLine());
//        playersArray[devChoice].displayName();
        //Gameplay loop
        Board board= new Board(animals);
        while (gameOver == false) {
            for (int x = 0; x < players; x++) {
                if (playersArray[x].getAlive() == true && playersOut == players - 1) {
                    System.out.println("Congratulations! " + playersArray[x].getName() + " has won the game!");
                    gameOver = true;
                    break;
                }
                currentPlayer += 1;
                if (currentPlayer > players) {
                    currentPlayer = 1;
                }
                System.out.println(playersArray[currentPlayer-1].getName() + "'s turn\tBalance:" + playersArray[currentPlayer-1].getBal());
                pChoiceValid = false;
                board.displayBoard(playersArray);
                do{
                    System.out.println("What would you like to do:\ta)Play\tb)Manage animals");
                    playerChoice = console.readLine().charAt(0);
                    if (playerChoice == 'a') {
                        playersArray[currentPlayer-1].updatePostition(dice.diceRoll());
                        pChoiceValid = true;
                        if(board.getTile(playersArray[currentPlayer-1].getPosition()).getAnimal() == null){
                            if(playersArray[currentPlayer-1].getPosition()==0){
                                System.out.println("Congratulations you have landed on start and earned £1000!");
                                playersArray[currentPlayer-1].updateBal(1000);
                            }
                            else if(playersArray[currentPlayer-1].getPosition()==13){
                                System.out.println("You have landed on a skip and lost your turn");
                                break;
                            }
                        }
                        else{
                            Animal temp = board.getTile(playersArray[currentPlayer-1].getPosition()).getAnimal();
                            System.out.println("You have landed on a "+temp.getAnimalName());
                            if(Objects.equals(temp.getAnimalOwner(), null)){
                                do {
                                    System.out.println("Would you like to buy "+temp.getAnimalName()+"\nPrice:"+temp.getCost()+"\nVisitPrice:"+temp.getCost()/10+"\tBalance: "+playersArray[currentPlayer-1].getBal());
                                    buyInput = console.readLine().charAt(0);
                                    if(buyInput == 'y'){
                                        temp.setAnimalOwner(playersArray[currentPlayer-1]);
                                        playersArray[currentPlayer-1].addAnimal(temp);
                                        playersArray[currentPlayer-1].updateBal(-temp.getCost());
                                        System.out.println("Bought "+temp.getAnimalName()+"!"+" new balance:"+playersArray[currentPlayer-1].getBal());
                                        buyValid=true;
                                    }
                                    else  if(buyInput == 'n'){
                                        buyValid=true;
                                    }
                                    else{
                                        System.out.println("Please enter 'y' or 'n'");
                                    }
                                }while(buyValid=false);
                            }
                            else{
                                System.out.println("This is"+(temp.getAnimalOwner().getName()+"'s"+temp.getAnimalName()+"\tYou pay them"+temp.getVisitPrice()));
                                playersArray[currentPlayer-1].updateBal(-temp.getCost());
                                temp.getAnimalOwner().updateBal(temp.getCost());
                                System.out.println("New balance: "+playersArray[currentPlayer-1].getBal()+"\t"+temp.getAnimalOwner().getName()+"balance: "+temp.getAnimalOwner().getBal());
                            }
                        }
                    }
                    else if (playerChoice == 'b') {
                        animalX =1;
                        System.out.println("Your animals:\n");
                        for(int i = 0; i < animals.length; i++){
                            if(animals[i] != null && animals[i].getAnimalOwner()==playersArray[currentPlayer-1]){
                                animalX+=1;
                                System.out.println(animalX+". "+playersArray[currentPlayer-1].getOwnedA(animalX-1).getAnimalName());
                            }
                        }
                        //aManage = console.readLine().charAt(0);
                        do {
                            if(animalX == 1) {
                                System.out.println("you don't have any animals..");
                                break;
                            }
                            System.out.println("Balance:" +playersArray[currentPlayer-1].getBal());
                            int sellCost = playersArray[currentPlayer-1].getOwnedA(animalX-1).getCost()/2*(1+(playersArray[currentPlayer-1].getOwnedA(animalX-1).getLevel())/10);
                            System.out.println("Would you like to:\ta) Sell"+playersArray[currentPlayer-1].getOwnedA(animalX-1).getAnimalName()+" is worth "+ sellCost+"\tb) Upgrade Current level: "+playersArray[currentPlayer-1].getOwnedA(animalX-1).getLevel()+"Upgrade cost: "+ playersArray[currentPlayer-1].getOwnedA(animalX-1).getCost()+"\tc) Back");
                            manageOption = console.readLine().charAt(0);
                            if(manageOption == 'a'){
                                playersArray[currentPlayer-1].updateBal(sellCost);
                                playersArray[currentPlayer-1].getOwnedA(animalX-1).setAnimalOwner(null);
                                playersArray[currentPlayer-1].removeAnimal(playersArray[currentPlayer-1].getOwnedA(animalX-1));
                            }
                            if(manageOption == 'b'){
                                if(playersArray[currentPlayer-1].getOwnedA(animalX-1).getLevel()==3){
                                    System.out.println("Is max level and cannot be upgraded further");
                                }
                                playersArray[currentPlayer-1].updateBal(-playersArray[currentPlayer-1].getOwnedA(animalX-1).getCost());
                                playersArray[currentPlayer-1].getOwnedA(animalX-1).setLevel(playersArray[currentPlayer-1].getOwnedA(animalX-1).getLevel()+1);
                            }
                            if(manageOption == 'c'){
                                manageValid = true;
                            }
                        }while(manageValid=false);
                    }
                    else {
                        System.out.println("This is invalid please try again");
                    }
                } while (pChoiceValid = false && playersArray[currentPlayer - 1].getAlive() == true);
                //Check for winner
                if (playersArray[currentPlayer - 1].getBal() <= 0 && playersArray[currentPlayer - 1].getAlive() == true) {
                    playersArray[currentPlayer - 1].updateAlive();
                    //lose game and sets animal owner to nul;
                    System.out.println("You have gone broke and are out of the game!");
                    for (int i = 0; i < animals.length; i++) {
                        if(animals[i]!= null && animals[i].getAnimalOwner()==playersArray[currentPlayer - 1]){
                            animals[i].setAnimalOwner(null);
                        }
                    }
                    playersOut += 1;
                }
            }
        }
    }
}