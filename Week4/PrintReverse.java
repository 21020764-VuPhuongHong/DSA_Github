public class PrintReverse {
    public void reversePrint(SinglyLinkedListNode llist) {
        if (llist != null) {
            int[] arr = new int[1000];
            int count = 0;
            SinglyLinkedListNode p = llist;
            while (p.next != null) {
                arr[count] = p.data;
                p = p.next;
                count++;
            }
            arr[count] = p.data;
            for (int i = count; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
}
