
import java.util.ArrayList;
import java.util.Random;

// Deck class is static because only 1 deck will ever exist
public class Deck {
    public static ArrayList<Card> deck;
    public static ArrayList<Card> cardsInPlay = new ArrayList<>();// Does not incluce hidden Cards

    // create a new deck of cards with support for multiple decks
    public static void newDeck(int numberOfDecks) {
        deck = new ArrayList<>();
        String[] suits = {"H", "D", "C", "S"};
        String[] values = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String suit : suits) {
            for (String value : values) {
                for (int i = 0; i < numberOfDecks; i++){
                    deck.add(new Card(suit, value));
                }
            }
        }
        System.out.println("New deck: " + deck + "\n" + "Deck size: " + deck.size());
    }

    //shuffles the deck
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

    // draws a card from the deck
    public static Card draw() {
        if (deck.isEmpty()) {
            System.out.println("Deck is empty");
            return null;
        }
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }  
    
    // calculates the value of a deck
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
