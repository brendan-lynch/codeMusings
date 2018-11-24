import java.util.HashMap;
import java.util.Map;

/*
Pattern
2,000,000,000 - break number into groups of three print hundreds, 10s, digit + comma position thousand, million, billion etc.
Detect negative, prepend number with negative value.
 */

public class NumberParser {

    public NumberParser(int value)
    {
        parse = value;
        sb = new StringBuilder();

        initializeDigitMap();
        initializeTensMap();
    }

    public NumberParser()
    {
        parse = 0;
        sb = new StringBuilder();

        initializeDigitMap();
        initializeTensMap();
    }

    public String parse()
    {
        int parseIterator = 1000000000;
        int hundredsValue = 0;
        while(parse > 0)
        {
            if(parseIterator > 0)
            {
                hundredsValue = parse / parseIterator;
            }
            else
            {
                hundredsValue = parse;
            }

            if(hundredsValue > 0)
            {
                hundreds(hundredsValue);
                appendLargeNumber(parseIterator);
            }

            parse %= parseIterator;
            parseIterator /= 1000;
        }

        // Delete leading white space.
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public void setParseValue(int value)
    {
        parse = value;
        sb = new StringBuilder();
    }

    private void digit(int value)
    {
        sb.append(digitMap.get(value));
    }

    private void tens(int value)
    {
        if(value > 19)
        {
            int tensValue = value / 10;
            int digitValue = value % 10;
            sb.append(tensMap.get(tensValue));
            digit(digitValue);
        }
        else
        {
            digit(value);
        }
    }

    private void hundreds(int value)
    {
        int hundredValue = value / 100;
        int tensValue = value % 100;
        if(hundredValue > 0)
        {
            digit(hundredValue);
            sb.append(" hundred");
        }

        tens(tensValue);
    }

    private void appendLargeNumber(int value)
    {
        if(value == 1000000000)
        {
            sb.append(" billion");
        }
        else if(value == 1000000)
        {
            sb.append(" million");
        }
        else if(value == 1000)
        {
            sb.append(" thousand");
        }
    }

    private void initializeDigitMap()
    {
        digitMap.put(0, "");
        digitMap.put(1, " one");
        digitMap.put(2, " two");
        digitMap.put(3, " three");
        digitMap.put(4, " four");
        digitMap.put(5, " five");
        digitMap.put(6, " six");
        digitMap.put(7, " seven");
        digitMap.put(8, " eight");
        digitMap.put(9, " nine");
        digitMap.put(10, " ten");
        digitMap.put(11, " eleven");
        digitMap.put(12, " twelve");
        digitMap.put(13, " thirteen");
        digitMap.put(14, " fourteen");
        digitMap.put(15, " fifteen");
        digitMap.put(16, " sixteen");
        digitMap.put(17, " seventeen");
        digitMap.put(18, " eighteen");
        digitMap.put(19, " nineteen");
    }

    private void initializeTensMap()
    {
        tensMap.put(2, " twenty");
        tensMap.put(3, " thirty");
        tensMap.put(4, " forty");
        tensMap.put(5, " fifty");
        tensMap.put(6, " sixty");
        tensMap.put(7, " seventy");
        tensMap.put(8, " eighty");
        tensMap.put(9, " ninety");
    }


    StringBuilder sb;
    int parse;
    Map<Integer, String> digitMap = new HashMap<>();
    Map<Integer, String> tensMap = new HashMap<>();
}
