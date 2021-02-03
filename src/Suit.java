
/**
 * This has the names of the suits its respective code for printing a unicode character, along with its
 * name
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public enum Suit
{
    // Suit names
    spades(0x1f0a0, "spades"),
    hearts(0x1f0b0, "hearts"),
    diamonds(0x1f0c0, "diamonds"),
    clubs(0x1f0d0, "clubs");
    // code is a hexadecimal integer, used for representing Unicode characters
    private final int code;
    private final String suitName;
    // defines code and suitName
    Suit(int c, String s)
    {
        code = c;
        suitName = s;
    }
    // Getters
    public int getCode()
    {
        return code;
    }
    public String getSuitName()
    {
        return suitName;
    }
}

