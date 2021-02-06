import java.awt.*;

/**
 * This combines the suit and value to form a card. When printed, it draws the unicode character of the
 * card
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public class Card
{
    // cardPic is the unicode character of the card
    private final String cardFace, cardBack;
    // The suit and value of the card
    public final Suit SUIT;
    public final Value CARD_NAME;
    // numerical value of the card (as in the number of points_
    public final int VALUE;
    public final Color COLOR;
    public boolean faceUp;

    public Card(Suit s, Value v)
    {
        // Using the enumerated suit and value codes, you can represent a unicode character
        // in the the string cardPic
        // The appendCodePoint() method translates an integer to its unicode representation
        // in a string.
        // I got this code from Stack Overflow
        cardFace = new StringBuilder().appendCodePoint(s.getCode()+v.getCode()).toString();
        cardBack = new StringBuilder().appendCodePoint(0x1f0a0).toString();
        // the suit, number value, and the card value name
        SUIT = s;
        VALUE = v.getValue();
        CARD_NAME = v;
        faceUp = true;
        if (SUIT == Suit.hearts || SUIT == Suit.diamonds) {
            COLOR = Color.red;
        } else {
            COLOR = Color.black;
        }
    }
    // returns the unicode character of the card in a string
    public String toString()
    {
        if (faceUp)
            return cardFace;
        else
            return cardBack;
    }

    public Color getColor()
    {
        if (faceUp)
            return COLOR;
        else
            return Color.black;
    }

    public void setFaceUp(boolean f)
    {
        faceUp = f;
    }

    public void flip()
    {
        faceUp = !faceUp;
    }
}
