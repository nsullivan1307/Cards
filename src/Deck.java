import java.util.Arrays;
import java.util.Random;
import java.util.ArrayDeque;
/**
 * This begins as a full deck, but when the remove card method is called, the card
 * is removed from the array, and the number of cards is decreased
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public class Deck extends ArrayDeque<Card>
{
    // a random generator
    private final Random gen;

    public Deck(Card[] cardArray)
    {
        super(Arrays.asList(cardArray));
        // The random generator
        gen = new Random();
    }
    public static Deck makeEmpty()
    {
        Card[] cards = {};
        return new Deck(cards);
    }

    public static Deck makeFull()
    {
        Card[] cards = new Card[52];
        // An array of suits and an array of values to create the cards in the deck
        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        // for each suit and each value, create a card
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 13; j++)
            {
                cards[13*i+j] = new Card(suits[i], values[j]);
                cards[13*i+j].flip();
            }
        }
        return new Deck(cards);
    }

    public void flipDeck()
    {
        // Dumps cards into array
        Card[] cards = toArray(new Card[0]);
        int numCards = size();
        for (int i = 0; i < numCards; i++)
        {
            removeLast();
            addFirst(cards[i]);
        }
    }

    public void shuffle()
    {
        // Dumps cards into array
        Card[] cards = toArray(new Card[0]);
        int index;
        int numCards = size();
        int numArray = numCards;
        for (int i = 0; i < numCards; i++)
        {
            index = gen.nextInt(numArray);
            removeLast();
            addFirst(cards[index]);
            numArray--;
            if (numArray - index >= 0) System.arraycopy(cards, index + 1, cards, index, numArray - index);
        }
    }
}
