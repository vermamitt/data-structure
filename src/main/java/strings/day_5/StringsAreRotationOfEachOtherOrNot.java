package strings.day_5;

public class StringsAreRotationOfEachOtherOrNot {
    public static void main(String[] args) {
        System.out.println("isRotated : " + isRotated("ABACD", "CDABA"));
        System.out.println("isRotated : " + isRotated("ABACD", "CDABAA"));
        System.out.println("isRotated : " + isRotated("ab", "a"));
    }

    private static boolean isRotated(String str1, String str2) {
        return str1.length() == str2.length() && str1.concat(str1).contains(str2);
    }
}
