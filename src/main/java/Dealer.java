import java.util.ArrayList;

public class Dealer {

	Deck theDeck;
	ArrayList<Card> dealersHand;

	Dealer() {
		theDeck = new Deck();
		dealersHand = new ArrayList<Card>();
	}

	public ArrayList<Card> dealHand() {

		if (theDeck.size() <= 34) {
			theDeck.newDeck();
		}

		ArrayList<Card> output = new ArrayList<Card>();

		for (int i = 0; i < 3; i ++) {
			output.add(i, theDeck.get(0));
			theDeck.remove(0);
		}

		return output;
	}
	
}
