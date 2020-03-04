import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class threeCardLogicTest {
	
	ArrayList<Card> hand;
	ArrayList<Card> hand2;
	@BeforeEach
	void init() {
		hand = new ArrayList<Card>();
		hand2 = new ArrayList<Card>();
	}
	
	//Testing for the evalHand function 
	
	@Test 
	void testPairInBack() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('H',2);
		Card card3 = new Card('S',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(5, ThreeCardLogic.evalHand(hand));
	}
	
	@Test
	void testPairInFront() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',7);
		Card card3 = new Card('H',5);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(5,ThreeCardLogic.evalHand(hand));
	}
	
	@Test 
	void testFlush() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('H',5);
		Card card3 = new Card('H',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(4, ThreeCardLogic.evalHand(hand));
		
	}
	
	@Test
	void testStraight() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('H',6);
		Card card3 = new Card('C',5);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(3, ThreeCardLogic.evalHand(hand));
		
	}
	
	@Test
	void testThreeOfKind() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',7);
		Card card3 = new Card('S',7);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(2, ThreeCardLogic.evalHand(hand));
	}
	
	@Test 
	void testStraightFlush() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('H',6);
		Card card3 = new Card('H',5);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(1, ThreeCardLogic.evalHand(hand));
	}
	
	@Test 
	void testNoHand() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',5);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(0, ThreeCardLogic.evalHand(hand));
	}
	
	//End of testing of the EvalHand function 
	
	//Testing of bet function (EvalPPWinnings)
	
	@Test
	void testStraightFlushBet() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('H',6);
		Card card3 = new Card('H',5);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(41,ThreeCardLogic.evalPPWinnings(hand, 1));
		assertEquals(82,ThreeCardLogic.evalPPWinnings(hand, 2));
	}
	
	@Test
	void testPairBet() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('C',7);
		Card card3 = new Card('H',5);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(2,ThreeCardLogic.evalPPWinnings(hand, 1));
		assertEquals(4,ThreeCardLogic.evalPPWinnings(hand, 2));
	}
	
	@Test
	void testFlushBet() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('H',5);
		Card card3 = new Card('H',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(4,ThreeCardLogic.evalPPWinnings(hand, 1));
		assertEquals(8,ThreeCardLogic.evalPPWinnings(hand, 2));
	}
	
	@Test
	void testStraightBet() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('C',6);
		Card card3 = new Card('D',5);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(7,ThreeCardLogic.evalPPWinnings(hand, 1));
		assertEquals(14,ThreeCardLogic.evalPPWinnings(hand, 2));
	}
	
	@Test
	void testThreeofKindBet() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',7);
		Card card3 = new Card('C',7);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(31,ThreeCardLogic.evalPPWinnings(hand, 1));
		assertEquals(62,ThreeCardLogic.evalPPWinnings(hand, 2));
	}
	
	@Test 
	void testLostBet() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',5);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(0,ThreeCardLogic.evalPPWinnings(hand, 1));
		assertEquals(0,ThreeCardLogic.evalPPWinnings(hand, 2));
	}
	
	//End of testing of bet function (EvalPPWinnings)
	
	//Testing compareHands
	
	@Test 
	void testSecondHandWin() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',5);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',7);
		Card cardTwo = new Card('H',5);
		Card cardThree = new Card('H',2);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(2,ThreeCardLogic.compareHands(hand, hand2));
	}
	
	@Test
	void testFirstHandWins() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',5);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',7);
		Card cardTwo = new Card('H',5);
		Card cardThree = new Card('H',2);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(1,ThreeCardLogic.compareHands(hand2, hand));
	}
	
	@Test
	void testStraightFlushVsStraight() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('H',6);
		Card card3 = new Card('H',5);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',7);
		Card cardTwo = new Card('D',6);
		Card cardThree = new Card('C',5);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(1,ThreeCardLogic.compareHands(hand, hand2));
	}
	
	@Test
	void testPairVsFlush() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',7);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',7);
		Card cardTwo = new Card('H',5);
		Card cardThree = new Card('H',2);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(2,ThreeCardLogic.compareHands(hand, hand2));
	}
	
	@Test
	void testTieWithItself() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',5);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		assertEquals(0,ThreeCardLogic.compareHands(hand, hand));
	}
	
	@Test
	void testTieWithAnotherHand() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('D',5);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',7);
		Card cardTwo = new Card('D',5);
		Card cardThree = new Card('H',2);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(0,ThreeCardLogic.compareHands(hand, hand2));
	}
	
	@Test
	void testNoSpecialButFirstCardHigh() {
		Card card1 = new Card('H',8);
		Card card2 = new Card('D',5);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',7);
		Card cardTwo = new Card('D',5);
		Card cardThree = new Card('H',2);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(1,ThreeCardLogic.compareHands(hand, hand2));
	}
	
	@Test
	void testNoSpecialButSecondCardHigh() {
		Card card1 = new Card('H',9);
		Card card2 = new Card('D',6);
		Card card3 = new Card('C',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',9);
		Card cardTwo = new Card('D',5);
		Card cardThree = new Card('H',2);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(1,ThreeCardLogic.compareHands(hand, hand2));
	}
	
	@Test
	void testNoSpecialButThirdCardHigh() {
		Card card1 = new Card('H',8);
		Card card2 = new Card('D',5);
		Card card3 = new Card('C',3);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',8);
		Card cardTwo = new Card('D',5);
		Card cardThree = new Card('H',2);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(1,ThreeCardLogic.compareHands(hand, hand2));
	}
	
	@Test 
	void SpecialVsNoSpecialHands() {
		Card card1 = new Card('H',7);
		Card card2 = new Card('H',5);
		Card card3 = new Card('H',2);
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		Card cardOne= new Card('H',7);
		Card cardTwo = new Card('D',5);
		Card cardThree = new Card('H',2);
		hand2.add(cardOne);
		hand2.add(cardTwo);
		hand2.add(cardThree);
		assertEquals(1,ThreeCardLogic.compareHands(hand, hand2));
	}
	
	//End of testing compareHands
	
	//End of testing 
	
	
	
	
	
	
	
	
	
}
