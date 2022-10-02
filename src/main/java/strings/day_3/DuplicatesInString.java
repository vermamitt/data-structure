package strings.day_3;

import java.util.HashMap;

public class DuplicatesInString {
    public static void main(String[] args) {
        String amitVerma = "amitVerma";
        String amitVermaA = "amitVermaA";
        findDuplicates(amitVerma);
        System.out.println();
        findDuplicates(amitVermaA);
    }

    private static void findDuplicates(String string) {
        char[] chars = string.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();
        for (char e : chars) {
            if (map.get(String.valueOf(e)) == null) {
                map.put(String.valueOf(e), 1);
            } else {
                map.put(String.valueOf(e), map.get(String.valueOf(e)) + 1);
            }
        }
        map.entrySet().stream().forEach(System.out::println);
    }
}
