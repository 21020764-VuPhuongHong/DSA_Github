import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        boolean checkChaotic = false;
        int count = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) == i + 1) {
                continue;
            } else if (i >= 1 && q.get(i - 1) == i + 1) {
                int temp = q.get(i - 1);
                q.set(i - 1, q.get(i));
                q.set(i, temp);
                count++;
            } else if (i >= 2 && q.get(i - 2) == i + 1) {
                int temp = q.get(i - 2);
                q.set(i - 2, q.get(i - 1));
                q.set(i - 1, temp);

                temp = q.get(i - 1);
                q.set(i - 1, q.get(i));
                q.set(i, temp);
                count += 2;
            } else {
                System.out.println("Too chaotic");
                checkChaotic = true;
                break;
            }
        }

        if (!checkChaotic) {
            System.out.println(count);
        }
    }
}