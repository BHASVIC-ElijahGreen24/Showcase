public class Deck {

    Card[] deck;

    public Deck(){

        Card[] deck; // this creates the array deck
        deck = new Card[20]; // this creates the size of the array (20 for 20 cards)
        deck[0] = new Card("You have received a donation of £50.", 50); // all of these below declare each individual card in the array // positives:
        deck[1] = new Card("You have gained £50 through interest.", 50);
        deck[2] = new Card("Tax refund. Collect £100.", 100);
        deck[3] = new Card("Sale of stock. Collect £100.", 100);
        deck[4] = new Card("You have received a government grant of £150.", 150);
        deck[5] = new Card("Bank pays you dividend of £200.", 200);
        deck[6] = new Card("A sponsorship grants you £200.", 200);
        deck[7] = new Card("You inherit £250.", 250);
        deck[8] = new Card("You have benefitted £300 after a successful investment.", 300);
        deck[9] = new Card("MrBeast visits your animals and leaves a tip. Collect £500.", 500);

        deck[10] = new Card("Animal food costs you £50.", -50); // negatives:
        deck[11] = new Card("Speeding fine. Pay £50.", -50);
        deck[12] = new Card("Doctors fees. Pay £100.", -100);
        deck[13] = new Card("Maintenance fees cost you £100.", -100);
        deck[14] = new Card("Vet fees. Pay £150.", -150);
        deck[15] = new Card("Gardeners fees. Pay £200.", -200);
        deck[16] = new Card("Your enclosures need repair. This costs you £200.", -200);
        deck[17] = new Card("You owe £250 in taxes.", -250);
        deck[18] = new Card("Your investment failed and you lost £300.", -300);
        deck[19] = new Card("It cost you £500 to rescue an escaped animal.", -500);

        this.deck = deck;
    }

    public Card drawCard(){
        int random = (int) (Math.random() * 20); // int converts to integer, Math.random() generates random number between 0.0 and 1.0, then *20 gives us a random number between 0 and 19
        return deck[random];
    }

}
