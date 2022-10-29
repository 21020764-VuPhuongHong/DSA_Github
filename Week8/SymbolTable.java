import java.util.Scanner;
import java.util.TreeMap;

public class SymbolTable {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if (treeMap.containsKey(str)) {
                treeMap.put(str, treeMap.get(str) + 1);
            } else {
                treeMap.put(str, 1);
            }
        }
        System.out.println(treeMap);
    }
}
