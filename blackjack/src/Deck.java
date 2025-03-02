
import java.util.ArrayList;
import java.util.Random;


public class Deck {
    public static ArrayList<Card> deck;
    public static ArrayList<Card> cardsInPlay;// Does not incluce hidden Cards

    public Deck() {

    }

    public static void newDeck() {
        deck = new ArrayList<>();
        String[] suits = {"H", "D", "C", "S"};
        String[] values = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String suit : suits) {
            for (String value : values) {
                deck.add(new Card(suit, value));
            }
        }
        System.out.println("New deck: " + deck + "\n" + "Deck size: " + deck.size());
    }

    public static void shuffle() {
        Random random = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int r = random.nextInt(deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(r));
            deck.set(r, temp);
        }
        System.out.println("Shuffled Deck: " + deck);
    }

    public static Card draw() {
        if (deck.isEmpty()) {
            System.out.println("Deck is empty");
            return null;
        }
        Card card = deck.get(0);
        deck.remove(0);
        System.out.println("Drew card: " + card + "\n" + "Deck size: " + deck.size());
        return card;
    }  
    
    public static int calculateDeckValue(ArrayList<Card> deck) {
        int deckValue = 0;
        for (Card card : deck) {
            if (card.suit.equals("A") && deckValue + 11 <= 21) {
                deckValue += 11;
            } else {
                deckValue += Card.getCardValue(card);
            }
        }
        return deckValue;
    }

}
