public class InsertTail {
    public SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head != null) {
            SinglyLinkedListNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        } else {
            head = newNode;
        }
        return head;
    }
}
