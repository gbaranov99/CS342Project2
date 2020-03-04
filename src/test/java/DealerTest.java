import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class DealerTest {

	Dealer d;
	ArrayList<Card> hand;

	@BeforeEach
	void init() {
		d = new Dealer();
		hand = d.dealHand();
	}

	@Test
	void testDealerHandLength() {
		assertTrue(hand.size() == 3);
	}

	@Test
	void testDealerDeckLength() {
		assertTrue(d.theDeck.size() == 49);
	}

	@Test
	void testDealerCardsUnique() {

		boolean allUnique = true;

		for (int i = 0; i < hand.size(); i++) {
			for (int j = i + 1; j < hand.size(); j++) {
				if ( hand.get(i) == hand.get(j)) {
					allUnique = false;
				}
			}
		}

		assertTrue(allUnique);
	}

	@Test
	void testDealerCardsDecreaseInValue() {

		boolean decreasing = true;
		CompareCards comp = new CompareCards();

		for (int i = 0; i < hand.size(); i++) {
			for (int j = i + 1; j < hand.size(); j++) {
				if ( comp.compare(hand.get(i), hand.get(j)) > 0) {
					decreasing = false;
				}
			}
		}

		assertTrue(decreasing);
	}

	@Test
	void testDealerReshuffleUnder34Cards() {

		for (int i = 0; i < 7; i++) {
			d.dealHand();
		}

		assertFalse(d.theDeck.size() < 34);
	}

	@Test
	void testDealerReshuffleCreatesNewDeck() {

		Deck oldDeck = new Deck();
		for (int i = 0; i < d.theDeck.size(); i++) {
			oldDeck.add(i, d.theDeck.get(i));
		}

		for (int i = 0; i < 6; i++) {
			d.dealHand();
		}

		assertFalse(d.equals(oldDeck));
	}
}
