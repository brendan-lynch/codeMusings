/*
Given a number print that number using english words.
This should support numbers in the range of ints.

Examples:
    7 - Seven
    19 - nineteen
    136 - one hundred thirty six
    73,641 - seventy three thousand six hundred forty one
 */

public class Solution {
    public static void main(String[] args)
    {
        NumberParser parser = new NumberParser();

        /*
        Test base case
        for(int i = 0; i < 1000; i++)
        {
            parser.setParseValue(i);
            System.out.println(parser.parse());
        }
        */

        parser.setParseValue(1);
        System.out.println(parser.parse());

        parser.setParseValue(13);
        System.out.println(parser.parse());

        parser.setParseValue(467);
        System.out.println(parser.parse());

        parser.setParseValue(1000);
        System.out.println(parser.parse());

        parser.setParseValue(7321);
        System.out.println(parser.parse());

        parser.setParseValue(14309);
        System.out.println(parser.parse());

        parser.setParseValue(900000);
        System.out.println(parser.parse());

        parser.setParseValue(72892000);
        System.out.println(parser.parse());

        parser.setParseValue(472892020);
        System.out.println(parser.parse());

        parser.setParseValue(1000000000);
        System.out.println(parser.parse());

        parser.setParseValue(1180001040);
        System.out.println(parser.parse());
    }
}
