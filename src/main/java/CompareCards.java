import java.util.Comparator;

class CompareCards implements Comparator<Card> 
{ 

	// Returns positive if a's value > b's value, 0 if equal and negative if b's value > a's value
    public int compare(Card a, Card b) { 
		return a.value - b.value;
    } 

}
