public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        Deque<Character> newDeque = new LinkedListDeque<>();
        int size = wordDeque.size();
        for (int i = 0; i < size; i++) {
            newDeque.addLast(wordDeque.removeLast());
        }
        for (int i = 0; i < newDeque.size(); i++) {
            if (word.charAt(i) != newDeque.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        if (word.length() % 2 != 0) {
            int endIndexA = (word.length() - 1) / 2;
            String a = word.substring(0, endIndexA);
            String b = word.substring(endIndexA + 1);
            word = a + b;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        Deque<Character> newDeque = new LinkedListDeque<>();
        int size = wordDeque.size();
        for (int i = 0; i < size; i++) {
            newDeque.addLast(wordDeque.removeLast());
        }
        for (int i = 0; i < newDeque.size(); i++) {
            if (!cc.equalChars(word.charAt(i), newDeque.get(i))) {
                return false;
            }
        }
        return true;
    }

}
