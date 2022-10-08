public class InsertAtPosition {
    public SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (llist != null) {
            SinglyLinkedListNode p = llist;
            int count = 0;
            while (count < position - 1 && p.next != null) {
                p = p.next;
                count++;
            }
            SinglyLinkedListNode oldNode = p.next;
            p.next = newNode;
            newNode.next = oldNode;
        } else {
            llist = newNode;
        }
        return llist;
    }
}
