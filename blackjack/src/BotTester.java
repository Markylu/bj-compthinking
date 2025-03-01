
class BotTester {

	public static void test() {
		Deck.newDeck();
		Deck.shuffle();
		Player bot = new FiftyFiftyBot();
		bot.placeBet();
		System.out.println("Bot bet: " + bot.bet);
		bot.drawCard();
		bot.drawCard();
		System.out.println("Bot hand: " + bot.hand);
		System.out.println("Bot hand value: " + bot.handValue);
		bot.makeDecision();
		
	}
	
	public static void main(String[] args) {
		test();
	}
}
