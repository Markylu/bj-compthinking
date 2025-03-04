
// the card object
public class Card {
    String suit;
    String value;
    // hidden card of dealer
    Boolean isHidden = false;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    public Card(String suit, String value, Boolean isHidden) {
        this.suit = suit;
        this.value = value;
        this.isHidden = isHidden;
    }

    // get the path of the card image
    public String getCard(){
        if (isHidden) {
            return "./cards/BACK.png";
        }
        return "./cards/" + value + "-" + suit + ".png";
    }

    // get the value of the card
    public static int getCardValue(Card card) {
        return switch (card.value) {
            case "A" -> 1;
            case "J", "Q", "K" -> 10;
            default -> Integer.parseInt(card.value);
        };
    }

    @Override
    public String toString() {
        return value + "-" + suit;
    }


}
