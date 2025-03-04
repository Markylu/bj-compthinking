import java.util.ArrayList;
public class HardBot extends Player{
    public static double calculateExpectedValue(ArrayList<Card> deck) {
        double deckValue = 680.0;
        double cardNumber = 104;
        for (Card card : deck) {
            if (card.suit.equals("A") && deckValue + 11 <= 21) {
                deckValue -= 11;
                cardNumber--;
                //If it is an ace it adds 11 to the total deck value
                //card number total is also increased
            } else {
                deckValue -= Card.getCardValue(card);
                //Everything else gets added to the total
                cardNumber--;
            }
        }
        return deckValue/cardNumber;
        //it returns the average value of the remaining cards which is used in makeDecision()
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
        //The logic for the Hardbot for hitting or standing
        //Basically predicts the next cards average value and makes decision based on that
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

