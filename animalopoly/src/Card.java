public class Card {

    private String scenario; // every card has a unique scenario
    private int amount; // stores the value of money added to or removed after drawing card

    public Card(String cardScenario, int cardAmount) {
        scenario = cardScenario;
        amount = cardAmount;
    }

    public String getScenario() {
        return scenario;
    }

    public int getAmount() {
        return amount;
    }
}
