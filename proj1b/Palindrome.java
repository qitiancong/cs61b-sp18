public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> wordDeque= new LinkedListDeque<>();
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
        for(int i = 0; i < wordDeque.size(); i++) {
            newDeque.addLast(wordDeque.removeLast());
        }
        for(int i = 0; i < newDeque.size(); i++) {
            if (word.charAt(i) != newDeque.get(i)) {
                return false;
            }
        }
        return true;
    }

}
