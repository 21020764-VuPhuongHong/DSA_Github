public class GetNodeValue {
    public int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        SinglyLinkedListNode p = llist;
        int[] arr = new int[1000];
        int count = 0;
        while (p.next != null) {
            arr[count] = p.data;
            p = p.next;
            count++;
        }
        arr[count] = p.data;
        return arr[count - positionFromTail];
    }
}
