import java.util.Random;
/**
 * This begins as a full deck, but when the remove card method is called, the card
 * is removed from the array, and the number of cards is decreased
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public class Deck
{
    // A card array to represent the deck
    private final Card[] d1;
    // a random generator
    private final Random gen;
    // The number of cards
    private int numCards;

    public Deck()
    {
        // the number of cards is 52
        numCards = 52;
        // the deck is 52 cards in length
        d1 = new Card[numCards];
        // for each suit and each value, create a card
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 13; j++)
            {
                // An array of suits and an array of values to create the cards in the deck
                Suit[] suits = Suit.values();
                Value[] values = Value.values();
                d1[13*i+j] = new Card(suits[i], values[j]);
            }
        }
        // The random generator
        gen = new Random();
    }
    // This returns a card and removes this card from the deck
    public Card removeRandomCard()
    {
        // generates an index for the card
        int index = gen.nextInt(numCards);
        // creates the card to be removed
        // the card for remove from the deck
        Card cardOut = d1[index];
        // for each value in the deck after the card to be taken out,
        // shift each value down one index
        if (numCards - 1 - index >= 0) System.arraycopy(d1, index + 1, d1, index, numCards - 1 - index);
        // Decreases the number of cards
        numCards--;
        // returns the card
        return cardOut;
    }
}
