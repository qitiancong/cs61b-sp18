import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();


    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
    }

    @Test
    public void testOffByN() {
        OffByN offby5 = new OffByN(5);

        assertTrue(offby5.equalChars('a', 'f'));
        assertTrue(offby5.equalChars('f', 'a'));
        assertFalse(offby5.equalChars('f', 'h'));
    }

}
