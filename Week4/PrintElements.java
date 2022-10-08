public class PrintElements {
    public void printLinkedList(SinglyLinkedListNode head) {
        if (head != null) {
            SinglyLinkedListNode p = head;
            while (p.next != null) {
                System.out.println(p.data);
                p = p.next;
            }
            System.out.println(p.data);
        }
    }
}
