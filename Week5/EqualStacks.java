import java.util.List;

public class EqualStacks {
    private boolean checkEqual(int h1, int h2, int h3) {
        return (h1 == h2 && h1 == h3);
    }

    public int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int height1 = 0;
        for (int i = h1.size() - 1; i >= 0; i--) {
            height1 += h1.get(i);
            stack1.push(h1.get(i));
        }
        int height2 = 0;
        for (int i = h2.size() - 1; i >= 0; i--) {
            height2 += h2.get(i);
            stack2.push(h2.get(i));
        }
        int height3 = 0;
        for (int i = h3.size() - 1; i >= 0; i--) {
            height3 += h3.get(i);
            stack3.push(h3.get(i));
        }

        if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
            return 0;
        }

        while (!checkEqual(height1, height2, height3)) {
            if (height1 > height2) {
                height1 -= stack1.pop();
            } else if (height2 > height3) {
                height2 -= stack2.pop();
            } else {
                height3 -= stack3.pop();
            }
        }
        return height1;
    }
}
