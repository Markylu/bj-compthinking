
public class Dealer extends Player {
    Card hiddenCard;
    public Dealer() {
        super();
        playerID = 0;
    }

    @Override
    public void placeBet() {
        // dealer does not place bets
        System.out.println("Dealer does not place bets");
    }

    @Override
    public void drawCard() {
        // dealer draws a card
        if (hand.isEmpty()){
            hiddenCard = Deck.draw();
            hiddenCard.isHidden = true;
            hand.add(hiddenCard);
        } else {
            Card card = Deck.draw();
            hand.add(card);
            handValue += Card.getCardValue(card);
            if (card.value.equals("A")) {
                aceCount++;
            }
        }
        
    }

    public void revealHiddenCard() {
        if (hiddenCard != null) {
            hiddenCard.isHidden = false;
            hand.add(hiddenCard);
            handValue += Card.getCardValue(hiddenCard);
            if (hiddenCard.value.equals("A")) {
                aceCount++;
            }
            hiddenCard = null;
        }
    }



}
