import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void TestPalindrome() {
        String a = "racecar";
        String b = "abc";
        String c = "a";
        String d = "";
        assertTrue(palindrome.isPalindrome(a));
        assertFalse(palindrome.isPalindrome(b));
        assertTrue(palindrome.isPalindrome(c));
        assertTrue(palindrome.isPalindrome(d));
    }

    OffByOne cc = new OffByOne();
    @Test
    public void TestPalindromeOffByOne() {
        assertFalse(palindrome.isPalindrome("abc", cc));
        assertFalse(palindrome.isPalindrome("racecar", cc));
        assertTrue(palindrome.isPalindrome("flke", cc));

    }
}
