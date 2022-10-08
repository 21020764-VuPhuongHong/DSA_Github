import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        String s = "";
        stack.push(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        String data;
        while (q > 0) {
            data = br.readLine();
            s = stack.peek();
            if (data.charAt(0) == '1') {
                stack.push(s + data.substring(2));
            } else if (data.charAt(0) == '2') {
                int k = Integer.parseInt(data.substring(2));
                stack.push(s.substring(0, s.length() - k));
            } else if (data.charAt(0) == '3') {
                int j = Integer.parseInt(data.substring(2));
                System.out.println(s.charAt(j - 1));
            } else {
                stack.pop();
            }
            q--;
        }
    }
}
