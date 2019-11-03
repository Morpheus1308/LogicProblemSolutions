import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class LongestPalindrome {

    public LongestPalindrome(){

    }

    public static int longestPalindrome(final String s) {
        int longest = 1;
        if(s.length() > 0){
            for (int i = 0; i <= s.length(); i++) {
                for (int j = i; j <= s.length(); j++) {
                    System.out.println(i + " " +  j);
                    String word = s.substring(i, j);
                    System.out.println(word);
                    if(word.equals( new StringBuilder(word).reverse().toString()) && word.length() > longest){
                        longest = word.length();
                    }
                }
            }
            return longest;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(LongestPalindrome.longestPalindrome("aaaa"));
    }

    @Test
    public void basicTests() {
        doTest("a", 1);
        doTest("aa", 2);
        doTest("baa", 2);
        doTest("aab", 2);
        doTest("zyabyz", 1);
        doTest("baabcd", 4);
        doTest("baablkj12345432133d", 9);
    }
    private void doTest(final String s, int expected) {
        assertEquals(expected, longestPalindrome(s));
    }
}
