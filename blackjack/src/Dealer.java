
public class Dealer extends Player {
    Card hiddenCard;
    public Dealer() {
        super();
        this.name = "Dealer";
        playerID = 0;
    }

    @Override
    public void placeBet() {
        // dealer does not place bets
        System.out.println("Dealer does not place bets");
    }
    
    @Override
    public void makeDecision() {
        hiddenCard.isHidden = false;
        if (handValue < 17){
            do {
                hit();
                calculateHandValue();
                table.repaint();
            } while (handValue < 17);
            if (handValue > 21) {
                bust();
            } else {
                stand();
            }
        } 
    }

    @Override
    public void drawCard() {
        // dealer draws a card
        if (hand.isEmpty()){
            hiddenCard = Deck.draw();
            hiddenCard.isHidden = true;
            hand.add(hiddenCard);
            if (Deck.cardsInPlay!=null) {
            Deck.cardsInPlay.remove(hiddenCard);
        }
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
            hiddenCard.isHidden = true;
            hand.add(hiddenCard);
            handValue += Card.getCardValue(hiddenCard);
            if (hiddenCard.value.equals("A")) {
                aceCount++;
            }
            hiddenCard = null;
        }
    }



}
