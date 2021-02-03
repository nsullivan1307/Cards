
/**
 * These are the values of the cards and hexadecimal integer to be added to the Suit hexadecimal integer
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public enum Value
{
    // card values
    ace(0x1, "ace", 1),
    two(0x2, "2", 2),
    three(0x3, "3", 3),
    four(0x4, "4", 4),
    five(0x5, "5", 5),
    six(0x6, "6", 6),
    seven(0x7, "7", 7),
    eight(0x8, "8", 8),
    nine(0x9, "9", 9),
    ten(0xa, "10", 10),
    jack(0xb, "jack", 10),
    queen(0xd, "queen", 10),
    king(0xe, "king", 10);
    // Defines hexadecimal code for unicode characters and the value of the card
    private final int code;
    private final int value;
    private final String valueName;
    // Defines the code, value and name of each card
    Value(int c, String s, int val)
    {
        code = c;
        valueName = s;
        value = val;
    }
    // Getters
    public int getCode()
    {
        return code;
    }
    public String getValueName()
    {
        return valueName;
    }
    public int getValue()
    {
        return value;
    }
}
