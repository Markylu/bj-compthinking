
public class Card {
    String suit;
    String value;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public String getCard(){
        return "blackjack/cards/" + value + "-" + suit + ".png";
    }

    @Override
    public String toString() {
        return value + "-" + suit;
    }

}
