package strings.day_2;

public class PalindromeOrNot {
    public static void main(String[] args) {
        String abc = "abc";
        String aba = "aba";
        String abba = "abba";
        String abcd = "abcd";
        System.out.println("isPalindrome(abc) = " + isPalindrome(abc, abc.length()));
        System.out.println("isPalindrome(aba) = " + isPalindrome(aba, aba.length()));
        System.out.println("isPalindrome(abba) = " + isPalindrome(abba, abba.length()));
        System.out.println("isPalindrome(abcd) = " + isPalindrome(abcd, abcd.length()));
    }

    private static boolean isPalindrome(String string, int size) {
        char[] chars = string.toCharArray();
        for (int i = 0; i <= (size - 1) / 2; i++) {
            if (chars[i] != chars[size - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
