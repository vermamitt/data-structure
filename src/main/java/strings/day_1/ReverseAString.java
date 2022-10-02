package strings.day_1;

public class ReverseAString {
    public static void main(String[] args) {
        String hello[] = {"h", "e", "l", "l", "o"};
        reverse(hello, hello.length - 1);
        for (String e : hello) {
            System.out.print(e + " ");
        }
        System.out.println("");
        String amit[] = {"a", "m", "i", "t"};
        reverse(amit, amit.length - 1);
        for (String e : amit) {
            System.out.print(e + " ");
        }
    }

    private static void reverse(String[] array, int size) {
        for (int i = 0; i <= size / 2; i++) {
            String temp = array[i];
            array[i] = array[size - i];
            array[size - i] = temp;
        }
    }
}
