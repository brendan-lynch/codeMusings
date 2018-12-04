// Regex with * and .


// CASES
// 1. char at string position matches char at pattern position
// 2. pattern is a wild card
//     - In case 1 and 2 increment string and pattern by 1.
// 3. pattern is <char>* and char does not match string, this is fine * is empty.
// 4. pattern is <char>*and char does match string, incremment string and see if pattern still matches.
//     - NOTE: we check the empty case at each position after *. Meaning AAA and A*A are valid.
//             In the case where we get to the end of the string after a* we fail. backtrack and A* consumes 2 a's and then is empty matching pattern (a) to string (a)
public class Solution {

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.isMatch("abc", "abc") + " == true");
        System.out.println(s.isMatch("abc", "a.c") + " == true");
        System.out.println(s.isMatch("abc", ".*") + " == true");
        System.out.println(s.isMatch("abb", "a*abb") + " == true");
    }

    Result[][] memo;
    enum Result
    {
        TRUE, FALSE
    }
    public boolean isMatch(String s, String p)
    {
        memo =  new Result[s.length()+1][p.length()+1];

        return isMatchRecursive(s, p, 0, 0);
    }

    public boolean isMatchRecursive(String s, String p, int i, int j)
    {
        if(memo[i][j] != null)
        {
            return memo[i][j] == Result.TRUE;
        }

        boolean answer;
        if(j == p.length())
        {
            answer = i == s.length();
        }
        else
        {
            boolean first_match = (i < s.length() &&
                    (s.charAt(i) == p.charAt(j)|| p.charAt(j) == '.'));

            if(j + 1 < p.length() && p.charAt(j + 1) == '*')
            {
                answer = (isMatchRecursive(s, p, i, j + 2) || (first_match && isMatchRecursive(s, p, i + 1, j)));
            }
            else
            {
                answer = first_match && isMatchRecursive(s, p, i + 1, j + 1);
            }
        }

        memo[i][j] = answer ? Result.TRUE : Result.FALSE;
        return answer;
    }

}
