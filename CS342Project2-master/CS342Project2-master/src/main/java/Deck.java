import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {
	
	Deck() {
		
		this.newDeck();
	}

	void newDeck() {

		this.clear();

		for (int i = 0; i < 52; i++) {
			int suitNum = i / 13;
			char suitChar = 'a';
			int faceVal = (i % 13) + 2;

			switch (suitNum) {
				case 0: suitChar = 'C';
						break;
				case 1: suitChar = 'D';
						break;
				case 2: suitChar = 'S';
						break;
				case 3: suitChar = 'H';
						break;
			}

			Card newCard = new Card(suitChar, faceVal);
			this.add(i, newCard);
		}

		Collections.shuffle(this);
	}

}
