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
    private Card[] d1;
    // An array of suits and an array of values to create the cards in the deck
    private Suit[] suits = Suit.values();
    private Value[] values = Value.values();
    // a random generator
    private Random gen;
    // The number of cards
    private int numCards;
    // the card for remove from the deck
    private Card cardOut;
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
        cardOut = d1[index];
        // for each value in the deck after the card to be taken out,
        // shift each value down one index
        for (int i = index; i < numCards-1; i++)
        {
            d1[i] = d1[i+1];
        }
        // Decreases the number of cards
        numCards--;
        // returns the card
        return cardOut;
    }
}
