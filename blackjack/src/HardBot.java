import java.util.ArrayList;
public class HardBot extends Player{
    public static double calculateExpectedValue(ArrayList<Card> deck) {
        double deckValue = 0.0;
        double cardNumber = 0.0;
        for (Card card : deck) {
            if (card.suit.equals("A") && deckValue + 11 <= 21) {
                deckValue += 11;
                cardNumber++;
            } else {
                deckValue += Card.getCardValue(card);
                cardNumber++;
            }
        }
        return deckValue/cardNumber;
    }

    public HardBot(){
        super();
        this.name = "HardBot";
        playerID = 4;
    }

    @Override
    public void placeBet(){
        bet = 3*balance/10;
        status = "Bet Amount: " + bet;
    }

    @Override
    public void makeDecision(){
        calculateHandValue();
        if (handValue<16 && HardBot.calculateExpectedValue(Deck.deck)<6.5385){
            hit();
        }
        else if (handValue<17 && HardBot.calculateExpectedValue(Deck.deck)<6){
            hit();
        }
        else if(handValue<18 && HardBot.calculateExpectedValue(Deck.deck)<5){
            hit();
        }
        else if(handValue<19 && HardBot.calculateExpectedValue(Deck.deck)<4){
            hit();}
        else if(handValue<20 && HardBot.calculateExpectedValue(Deck.deck)<3){
            hit();}
        else if(handValue<21 && HardBot.calculateExpectedValue(Deck.deck)<2){
            hit();}
        else{
            stand();
        }
}
    }

