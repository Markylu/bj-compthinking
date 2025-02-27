
public class Dealer extends Player {
    Card hiddenCard;
    public Dealer() {
        super();
        playerID = 0;
    }

    @Override
    public void placeBets() {
        // dealer does not place bets
        System.out.println("Dealer does not place bets");
    }

    @Override
    public void drawCard() {
        // dealer draws a card
        if (hand.isEmpty()){
            hiddenCard = Deck.draw();
            hand.add(hiddenCard);
        }
        
        
        if (card.value.equals("A")) {
            aceCount++;
        }
        handValue += Card.getCardValue(card);
    }



}
