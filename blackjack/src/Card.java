
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

    public static int getCardValue(Card card) {
        return switch (card.value) {
            case "A" -> 11;
            case "J", "Q", "K" -> 10;
            default -> Integer.parseInt(card.value);
        };
    }

    @Override
    public String toString() {
        return value + "-" + suit;
    }

}
