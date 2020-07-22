public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDequeSolution<>();
        for (int i = 0; i < word.length(); i++)
            res.addLast(new Character(word.charAt(i)));
        return res;
    }

    public static boolean isPalindrome(String word) {
        if (word.length() < 2) return true;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i))
                return false;
        }

        return true;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() < 2) return true;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(len - 1 - i)))
                return false;
        }
        return true;
    }
}
