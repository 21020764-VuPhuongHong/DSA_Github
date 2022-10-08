public class PriorityQueue {
    private int[] queue;
    private int size;
    private int realNumOfElements;
    private int n = 0;

    public PriorityQueue(int k, int m) {
        this.size = k;
        this.realNumOfElements = m;
        queue = new int[size];
    }

    public void insert(int x) {
        queue[n++] = x;
    }

    public int deleteMin() {
        int min = 0;
        for (int i = 1; i < realNumOfElements; i++) {
            if (queue[i] < queue[min]) {
                min = i;
            }
        }
        int temp = queue[realNumOfElements - 1];
        queue[realNumOfElements - 1] = queue[min];
        queue[min] = temp;

        return queue[--realNumOfElements];
    }

    public void print() {
        for (int i = 0; i < realNumOfElements; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        PriorityQueue test = new PriorityQueue(10, 8);
        test.insert(1);
        test.insert(3);
        test.insert(5);
        test.insert(7);
        test.insert(95);
        test.insert(2);
        test.insert(-8);
        //test.insert(11);
        test.print();
        System.out.println(test.deleteMin());
        test.print();
        System.out.println(test.deleteMin());
        test.print();
    }
}
