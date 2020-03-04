import java.util.Comparator;

class SortByCards implements Comparator<Card> 
{ 

    public int compare(Card a, Card b) { 
		return a.value - b.value;
    } 

}
