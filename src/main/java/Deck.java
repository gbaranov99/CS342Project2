import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {

	Deck() {

		this.newDeck();
	}

	char getCharSuit(int suitNum) {

		char suitChar = 'a';
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
		return suitChar;
	}

	int getValSuit(char suitChar) {

		int suitNum = 0;
		switch (suitChar) {
			case 'C': suitNum = 0;
					break;
			case 'D': suitNum = 1;
					break;
			case 'S': suitNum = 2;
					break;
			case 'H': suitNum = 3;
					break;
		}
		return suitNum;
	}

	void newDeck() {

		this.clear();

		for (int i = 0; i < 52; i++) {
			int suitNum = i / 13;
			char suitChar = getCharSuit(suitNum);
			int faceVal = (i % 13) + 2;

			Card newCard = new Card(suitChar, faceVal);
			this.add(i, newCard);
		}

		Collections.shuffle(this);
	}

}
