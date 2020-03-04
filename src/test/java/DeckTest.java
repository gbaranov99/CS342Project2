import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DeckTest {

	Deck d;

	@BeforeEach
	void init() {
		d = new Deck();
	}

	@Test
	void testDeckLength() {
		assertEquals(52, d.size());
	}

	@Test
	void testDeckReturnCard() {
		Card testCard = d.get(0);
		d.remove(0);

		assertEquals(51, d.size());
	}

	@Test
	void testDeckShuffle() {
		Card card1 = d.get(0);
		d.remove(0);
		Card card2 = d.get(0);

		assertFalse(card1 == card2);
	}

}
