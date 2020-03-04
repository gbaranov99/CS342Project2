import java.util.ArrayList;

public class ThreeCardLogic {
	public static int evalHand(ArrayList<Card> hand) {
		int highVal = hand.get(0).value;
		if(hand.get(0).value == hand.get(1).value || hand.get(1).value == hand.get(2).value || hand.get(0).value == hand.get(2).value) {
			if (hand.get(1).value == hand.get(2).value && hand.get(1).value == hand.get(0).value) {
				return 2;
			}
			else {
				return 5;
			}
		}
		
		else if (hand.get(0).suit == hand.get(1).suit && hand.get(1).suit == hand.get(2).suit) {
			if(hand.get(1).value == (highVal -1) && hand.get(2).value == (highVal -2)) {
				return 1;
			}
			else {
				return 4;
			}
		}
		
		else if ( (hand.get(1).value ==(highVal -1)) && (hand.get(2).value == (highVal-2)) ) {
			return 3;
		}
		
		else {
			return 0; 
		}
	}
	
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
		int handVal = evalHand(hand);
		if (handVal == 0) {
			return 0;
		}
		else if (handVal == 1) {
			return (bet * 41);
		}
		else if (handVal == 2) {
			return (bet * 31);
		}
		else if (handVal == 3) {
			return (bet * 7);
		}
		else if (handVal == 4) {
			return (bet * 4);
		}
		else if (handVal == 5) {
			return (bet * 2);
		}
		else {
			System.out.print("Eval Hand Error");
			return -1;
		}
	}
	public static int compareHands (ArrayList<Card> dealer, ArrayList<Card> player) {
		int dealerVal = evalHand(dealer);
		int playerVal = evalHand(player);
		if(dealerVal == 0 && playerVal != 0) {
			return 2;
		}
		else if (playerVal == 0 &&  dealerVal != 0) {
			return 1;
		}
		
		else if(dealerVal < playerVal) {
			return 1;
		}
		
		else if (playerVal < dealerVal) {
			return 2;
		}
		
		else {
			for (int i = 0; i < 3 ; i++) {
				if (dealer.get(i).value < player.get(i).value) {
					return 1;
				}
				else if (player.get(i).value < dealer.get(i).value) {
					return 2;
				}
			}
			return 0;
		}
	}

}
