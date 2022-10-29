import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        for (int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - i - 1)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
