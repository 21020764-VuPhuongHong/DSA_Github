import java.util.Scanner;

public class Queue2Stacks {
    public static class StackQueue<Item> {
        private Stack<Item> firstStack = new Stack<>();
        private Stack<Item> secondStack = new Stack<>();

        public void enqueue(Item x) {
            firstStack.push(x);
        }

        public Item dequeue() {
            if (secondStack.isEmpty()) {
                if (firstStack.isEmpty()) {
                    return null;
                } else {
                    while (!firstStack.isEmpty()) {
                        secondStack.push(firstStack.pop());
                    }
                }
            }
            return secondStack.pop();
        }

        public Item peek() {
            if (secondStack.isEmpty()) {
                if (firstStack.isEmpty()) {
                    return null;
                } else {
                    while (!firstStack.isEmpty()) {
                        secondStack.push(firstStack.pop());
                    }
                }
            }
            return secondStack.peek();
        }
    }

    public static void main(String[] args) {
        StackQueue<String> stackQueue = new StackQueue<>();
        int q;
        int type;
        String x;
        Scanner scanner = new Scanner(System.in);
        q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            type = scanner.nextInt();
            if (type == 1) {
                x = scanner.next();
                stackQueue.enqueue(x);
            } else if (type == 2) {
                stackQueue.dequeue();
            } else {
                System.out.println(stackQueue.peek());
            }
        }
    }
}
