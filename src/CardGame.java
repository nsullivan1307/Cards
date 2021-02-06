/**
 * CardGame is the class that contains the necessary components of the actual
 * card game, interfacing with CardTable to tell the cards where to go, and
 * determine which moves are allowed.
 *
 * @author (Nicholas Sullivan)
 * @version (Feb 2021)
 */
public abstract class CardGame {
    private final CardTable table;

    public CardGame(CardTable table) {
        this.table = table;
    }

    public abstract Deck initialDeck();


}
